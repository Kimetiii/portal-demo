package com.example.portalback.drools.controller;

import com.alibaba.fastjson.JSON;
import com.drools.core.KieTemplate;
import com.example.portalback.drools.domain.ActivityRule;
import com.example.portalback.drools.entity.ActivityRuleEntity;
import com.example.portalback.drools.service.TestService;
import com.example.portalback.sys.bean.PermissionBean;
import org.drools.core.event.DefaultRuleRuntimeEventListener;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @AUTHOR lgp
 * @DATE 2018/9/3 14:46
 * @DESCRIPTION 测试接口 mysql h5
 **/
@RestController
@RequestMapping(value = "testNum1")
public class TestController {
	public static final Logger log = LoggerFactory.getLogger(TestController.class);

	@Resource
	TestService testService;

	@Resource
	KieTemplate kieTemplate;

	@PostMapping("/testKieTemplate")
	public void testKieTemplate(String param) throws InterruptedException {
		Thread.sleep(1000);
		KieSession kieSession = kieTemplate.getKieSession("rules.drl");
		kieSession.addEventListener(new DefaultRuleRuntimeEventListener() {
			@Override
			public void objectInserted(ObjectInsertedEvent event) {
				System.err.println("监听到插入数据");
				System.err.println("Object:" + event.getObject());
				System.err.println("Fact:" + event.getFactHandle());

			}
		});
		PermissionBean permissionBean = new PermissionBean();
		permissionBean.setName("狗");
		kieSession.insert(permissionBean);
		kieSession.fireAllRules();
	}

	@RequestMapping("/select1")
	public String select1(Map<String, Object> map) {
		ActivityRuleEntity activityRule = testService.select1();
		map.put("hello", JSON.toJSON(activityRule));
		log.info("activityRule={}", JSON.toJSON(activityRule));
		return "/index";
	}

	@RequestMapping("/selectAll")
	public List<ActivityRule> selectAll() {
		List<ActivityRule> list = testService.selectAll();
		return list;
	}

	@RequestMapping("/index")
	public String index(Map<String, Object> map) {
		log.info("index");
		map.put("hello", "from HiController map");
		return "/index";
	}
}
