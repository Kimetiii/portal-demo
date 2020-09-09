package com.example.portalback.drools.service;

import com.drools.core.KieTemplate;
import com.example.portalback.drools.dao.ActivityRuleRepository;
import com.example.portalback.drools.domain.ActivityRule;
import com.example.portalback.drools.entity.ActivityRuleEntity;
import com.example.portalback.drools.model.CreditCardApplyInfo;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @AUTHOR lgp
 * @DATE 2018/9/3 15:31
 * @DESCRIPTION
 **/
@Service
public class TestService {

	@Resource
	ActivityRuleRepository activityRuleRepository;

	@Resource
	KieTemplate kieTemplate;

	public List<ActivityRule> selectAll() {
		List<ActivityRuleEntity> activityRules = activityRuleRepository.selectAll();
		List<ActivityRule> list = new ArrayList<>();
		for (ActivityRuleEntity activityRule : activityRules) {
			ActivityRule rule = new ActivityRule();
			BeanUtils.copyProperties(activityRule, rule);
			list.add(rule);
		}
		return list;
	}

	public ActivityRuleEntity select1() {
		return activityRuleRepository.selectByPrimaryKey(1);
	}

	/**
	 * 执行规则文件
	 *
	 * @param client 客户id
	 * @param ruleName 规则文件
	 */
	public void creditCardApply(String client, String ruleName) {
		KieSession kieSession = kieTemplate.getKieSession("rules.drl");
/*		kieSession.addEventListener(new DefaultRuleRuntimeEventListener() {
			@Override
			public void objectInserted(ObjectInsertedEvent event) {
				System.err.println("监听到插入数据");
			}
		});*/
		CreditCardApplyInfo creditCardApplyInfo = new CreditCardApplyInfo();
		creditCardApplyInfo.setName("徐小德");
		creditCardApplyInfo.setSex("男");
		creditCardApplyInfo.setEducation(CreditCardApplyInfo.EDUCATION_4);
		creditCardApplyInfo.setTelephone("18362952955");
		creditCardApplyInfo.setMonthlyIncome(20000d);
		creditCardApplyInfo.setAddress("大连市甘井子区火炬路集电大厦");
		creditCardApplyInfo.setHasHouse(true);
		creditCardApplyInfo.setHasCar(true);
		creditCardApplyInfo.setHasCreditCardCount(0);
		creditCardApplyInfo.setCheckResult(true);
		creditCardApplyInfo.setQuota(0.0D);
		creditCardApplyInfo.setScore(0);
		creditCardApplyInfo.setModelName("creditCardApply");
		kieSession.insert(creditCardApplyInfo);

		kieSession.fireAllRules();
		System.out.println(creditCardApplyInfo.toString());
		System.err.println("creditCardApply规则执行完成 该客户分数为：" + creditCardApplyInfo.getScore());
	}
}
