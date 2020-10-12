package com.example.portalback.drools.generator;

import com.example.portalback.common.util.DateUtil;
import com.example.portalback.drools.domain.ActivityRule;
import com.example.portalback.drools.domain.RuleDTO;
import com.example.portalback.drools.executor.RuleExecutor;
import com.example.portalback.drools.manager.FactManager;
import org.drools.template.ObjectDataCompiler;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

/**
 * @AUTHOR lgp
 * @DATE 2018/9/3 15:58
 * @DESCRIPTION 规则生成器
 **/
public class RuleGenerator {
	private static final Logger log = LoggerFactory.getLogger(RuleGenerator.class);

	/**
	 * 根据传递进来的参数对象生规则
	 *
	 * @param ruleDTOs
	 */
	public void generateRules(List<RuleDTO> ruleDTOs) {
		Map<String, String> ruleMap = new HashMap<>();
		List<String> ruleDrls = new ArrayList<>();
		ruleDTOs.forEach(dto ->
				ruleMap.put(dto.getRuleName(), applyRuleTemplate(dto))
		);
		// 这里尝试直接生成规则文件
		createDrlFile(ruleMap);
		//规则的加载
		createOrRefreshDrlInMemory(ruleDrls);
	}

	// todo 需要判断是否存在同名文件 存在文件 做重写处理
	private void createDrlFile(Map<String, String> ruleMap) {

		ruleMap.forEach((k, v) -> {
			String path = "D:\\test/" + k + ".drl";
			File file = new File(path);
			try {
				if (!file.exists()) {
					file.createNewFile();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			writeFileAppend(path, v);
		});

		/*		for (String rule : rules) {
			String path = "D:\\test/" + CustomUtils.uuid() + ".drl";
			System.out.println(rule);
			File file = new File(path);
			try {
				if (!file.exists()) {
					file.createNewFile();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			writeFileAppend(path, rule);
		}*/
	}

	/**
	 * 功能描述:
	 * <覆盖写入>
	 *
	 * @param filePath 1
	 * @param Content  2
	 * @return void
	 * @author zhoulipu
	 * @date 2019/8/2 16:23
	 */
	private static void writeFileOverlay(String filePath, String Content) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(filePath);
			pw.write(Content);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.flush();
				pw.close();
			}
		}
	}

	/**
	 * 功能描述:
	 * <读取文件>
	 *
	 * @param filePath 1
	 * @return void
	 * @author zhoulipu
	 * @date 2019/8/2 16:24
	 */
	private static void readFile(String filePath) {
		InputStreamReader in = null;
		BufferedReader br = null;
		try {
			File file = new File(filePath);
			in = new InputStreamReader(new FileInputStream(file), "gbk");
			br = new BufferedReader(in);
			String s;
			// 逐行读取
			while ((s = br.readLine()) != null) {
				System.out.println(s);
			}
			br.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void writeFileAppend(String filePath, String Content) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(filePath, false);
			fw.write(Content);
			fw.flush();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据 Rule 生成 drl 的 String
	 */
	private String applyRuleTemplate(RuleDTO ruleDTO) {
		Map<String, Object> data = prepareData(ruleDTO);
		ObjectDataCompiler objectDataCompiler = new ObjectDataCompiler();
		// 模板文件生成drl String
		return objectDataCompiler
				.compile(Collections.singletonList(data), Thread.currentThread()
						.getContextClassLoader()
						.getResourceAsStream("demo-rule-template.drt"));
	}

	/**
	 * 根据Rule生成drl的map data
	 */
	protected Map<String, Object> prepareData(RuleDTO ruleDTO) {
		Map<String, Object> data = new HashMap<>();
		ActivityRule rule = ruleDTO.getRule();
		data.put("ruleCode", ruleDTO.hashCode());
		data.put("beginTime", DateUtil.dateToStringFormat(ruleDTO.getBeginTime(), "dd-MMM-yyyy"));
		data.put("endTime", DateUtil.dateToStringFormat(ruleDTO.getEndTime(), "dd-MMM-yyyy"));

		//todo 如何插入 fact 类型
		data.put("eventType", FactManager.getFactClassByEvent(rule.getEvent())
				.getName());

		data.put("rule", rule.getRuleValue());
		data.put("awardeeType", rule.getAwardeeType());
		data.put("score", rule.getScore());
//      data.put("ruleId", rule.getId());
//      data.put("joinChannels", ruleDTO.getJoinChannel());
//      data.put("priority", rule.getPriority());
//      log.info("data={}", JSON.toJSON(data));
		return data;
	}

	/**
	 * 根据String格式的Drl生成Maven结构的规则
	 *
	 * @param rules 规则文件格式字符串集合
	 */
	private void createOrRefreshDrlInMemory(List<String> rules) {

		/**
		 * KieServices：kie整体的入口,可以用来创建Container,resource,fileSystem等
		 * KieFileSystem：一个完整的文件系统,包括资源和组织结构
		 */

		KieServices kieServices = KieServices.Factory.get();
		KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
		kieFileSystem.generateAndWritePomXML(RuleExecutor.getReleaseId());

		for (String str : rules) {
			String temPath = "D:\\test/" + UUID.randomUUID() + ".drl";
			kieFileSystem.write(temPath, str);

		}
		KieBuilder kb = kieServices.newKieBuilder(kieFileSystem).buildAll();
		if (kb.getResults().hasMessages(Message.Level.ERROR)) {
			log.error("create rule in kieFileSystem Error", kb.getResults());
			throw new IllegalArgumentException("生成规则文件失败");
		}
		doAfterGenerate(kieServices);
	}

	/**
	 * 生成完毕后的清理工作，目前主要用于debug模式测试完毕后，从内存中清理掉规则文件。
	 */
	protected void doAfterGenerate(KieServices kieServices) {

	}

}
