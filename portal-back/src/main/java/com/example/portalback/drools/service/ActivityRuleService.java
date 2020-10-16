package com.example.portalback.drools.service;

import com.alibaba.fastjson.JSON;
import com.example.portalback.annotation.Fact;
import com.example.portalback.common.util.CopyUtil;
import com.example.portalback.common.util.FileUtils;
import com.example.portalback.common.util.LoginUtils;
import com.example.portalback.drools.dao.ActivityRuleRepository;
import com.example.portalback.drools.domain.ActivityRule;
import com.example.portalback.drools.domain.RegisterMqDTO;
import com.example.portalback.drools.domain.RuleDTO;
import com.example.portalback.drools.domain.RuleExecutorResult;
import com.example.portalback.drools.domain.fact.BaseFact;
import com.example.portalback.drools.domain.fact.RegisterFact;
import com.example.portalback.drools.entity.ActivityRuleEntity;
import com.example.portalback.drools.executor.RuleExecutor;
import com.example.portalback.drools.generator.RuleGenerator;
import com.example.portalback.drools.model.RuleModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @AUTHOR lgp
 * @DATE 2018/9/4 9:52
 * @DESCRIPTION
 **/

@Service
@Transactional
public class ActivityRuleService {
	public static final Logger log = LoggerFactory.getLogger(RuleService.class);

	@Resource
	TestService testService;

	@Resource
	ActivityRuleRepository activityRuleRepository;

	/**
	 * 增加规则
	 *
	 * @param ruleModel 规则入参
	 */
	public ActivityRuleEntity addRule(RuleModel ruleModel) {
		ActivityRuleEntity activityRuleEntity = new ActivityRuleEntity();
		activityRuleEntity.setId(ruleModel.getId());
		activityRuleEntity.setRuleName(ruleModel.getRuleName());
		activityRuleEntity.setEvent("CUSTOMER"); // TODO 这里先直接写死 FACT 类型 后期可以做成动态选择
		activityRuleEntity.setRuleValue(ruleModel.getRuleValue());
		activityRuleEntity.setScore(ruleModel.getScore());
		activityRuleEntity.setCreateBy(LoginUtils.getUserName());
		activityRuleEntity.setCreateTime(new Date());
		activityRuleEntity.setUpdateBy(LoginUtils.getUserName());
		activityRuleEntity.setUpdateTime(new Date());
		ActivityRuleEntity save = activityRuleRepository.save(activityRuleEntity);
		return save;
	}

	/**
	 * 查询所有规则
	 *
	 * @return List<ActivityRuleEntity>
	 */
	public List<ActivityRuleEntity> findAll() {
		return activityRuleRepository.findAll();
	}

	/**
	 * 加载规则
	 */
	public void loadRule() {
		try {
			// 从数据库里面取规则
			List<RuleDTO> ruleDTOs = getActivityRuleList();
			log.info("{}条加入规则引擎", ruleDTOs.size());
			if (!ruleDTOs.isEmpty()) {
				RuleGenerator generator = new RuleGenerator();
				// 根据入参 生成规则
				generator.generateRules(ruleDTOs);
			}
		} catch (Exception e) {
			log.error("RuleService.loadRule。e={}", e.getMessage(), e);
		}
	}

	public void deleteRuleById(RuleModel ruleModel) {
		// todo 删除规则文件
		String path = "D:\\test/" + ruleModel.getRuleName() + ".drl";
		FileUtils.deleteFile(path);
		activityRuleRepository.deleteById(ruleModel.getId());
	}

	/**
	 * 触发规则 两条入参均为数据库里面存储的 rule_value 规则值
	 *
	 * @param userId 用户id
	 * @param phone  手机号码
	 */
	public void useRule(String userId, String phone) {
		// 构建BaseFact
		BaseFact fact = buildBaseFact(userId);
		/**
		 * 因为是uuid所以修改了的规则，重载加载是新的drl，故从数据库动态加载之时，is_delete属性要注意
		 * */
		String orderId = UUID.randomUUID().toString();
		/**
		 * 此处应当是从其他服务获取的的消息体，而不是空值
		 * */
		RegisterMqDTO domain = new RegisterMqDTO();
		domain.setTelephone(phone);
		try {
			/*可以知道一条信息，匹配了多少个规则，成功了几个*/
			RuleExecutorResult ruleExecutorResult = beforeExecute(orderId, fact, domain);
			log.info("RuleService|useRule|ruleExecutorResult={}", JSON.toJSON(ruleExecutorResult));
			Assert.isTrue(ruleExecutorResult.getFailure() == 0, String.format("有%d条规则执行失败", ruleExecutorResult.getFailure()));
		} catch (Exception e) {
			log.error("RuleService|useRule|class={},orderId={}, userId={}, 规则执行异常:{}", this.getClass().getName(), orderId, "123456789", e.getMessage(), e);
		}
	}

	/**
	 * 从数据库里面取规则
	 */
	public List<RuleDTO> getActivityRuleList() {
		Date begin = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()); // 开始时间
		Date end = Date.from(LocalDateTime.now().plusDays(1).atZone(ZoneId.systemDefault()).toInstant()); // 结束时间
		// 查询数据库中的所有信息
		List<ActivityRule> list = testService.selectAll();
		List<RuleDTO> ruleDTOList = new ArrayList<>();
		for (ActivityRule dto : list) {
			RuleDTO ruleDTO = new RuleDTO();
			ruleDTO.setRuleName(dto.getRuleName());
			ruleDTO.setBeginTime(begin);
			ruleDTO.setEndTime(end);
			ruleDTO.setRule(dto);
			ruleDTO.setScore(dto.getScore());
			ruleDTOList.add(ruleDTO);
		}
		return ruleDTOList;
	}

	/**
	 * 执行前
	 */
	public RuleExecutorResult beforeExecute(String orderId, BaseFact fact, RegisterMqDTO domain) {
		RegisterFact registerFact = buildRegisterFact(domain);
		CopyUtil.copyPropertiesCglib(fact, registerFact);
		log.info("RuleService|beforeExecute|{}事件的orderId={}, RegisterMqDTO={}",
				registerFact.getClass().getAnnotation(Fact.class).value(), orderId, domain);
		return RuleExecutor.execute(registerFact, orderId);
	}

	/**
	 * 生成初始的baseFact
	 */
	public BaseFact buildBaseFact(String userId) {
		BaseFact fact = new BaseFact();
//        此处应获取用户的信息
//        fact.setCust();
		fact.setUserId(userId);
		return fact;
	}

	/**
	 * 生成初始的registerFact
	 */
	private RegisterFact buildRegisterFact(RegisterMqDTO domain) {
		RegisterFact registerFact = new RegisterFact();

		CopyUtil.copyPropertiesCglib(domain, registerFact);
		return registerFact;
	}
}
