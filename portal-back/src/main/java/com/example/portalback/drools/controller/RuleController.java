package com.example.portalback.drools.controller;

import com.example.portalback.drools.service.ActivityRuleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @AUTHOR lgp
 * @DATE 2018/9/4 9:48
 * @DESCRIPTION 规则引擎接口
 * 这里其实只是为了给你们方便测试，实际上
 * <p>
 * loadRule 应该是服务器必须启动一次的，而loadRule则是配套的后台系统对数据库的规则进行了操作之后调用一次
 * <p>
 * useRule 则是客户端通过消息中间件触发，而不应该暴露出来
 */

@RestController
@RequestMapping(value = "/ruleLoadAndUse")
public class RuleController {

	@Resource
	ActivityRuleService activityRuleService;

	/**
	 * 这里是一个加载规则的接口
	 *
	 * @param map map
	 * @return index
	 */
	@PostMapping("/loadRule")
	public String loadRule(Map<String, Object> map) {
		activityRuleService.loadRule();
		map.put("hello", " loadRule");
		return "/index";

	}

	@PostMapping("/useRule")
	public String useRule(Map<String, Object> map) {
		activityRuleService.useRule("123456", "13712750166");
		map.put("hello", " useRule");
		return "/index";
	}

	@PostMapping("/useRule2")
	public String useRule2(Map<String, Object> map) {
		activityRuleService.useRule("123456", "13712750156");
		map.put("hello", " useRule2");
		return "/index";
	}
}
