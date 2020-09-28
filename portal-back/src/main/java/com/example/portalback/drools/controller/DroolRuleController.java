package com.example.portalback.drools.controller;

import com.example.portalback.common.entity.ResponseObj;
import com.example.portalback.drools.service.RuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author songsenior
 * @date 2020/7/29 09:43
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/dut")
public class DroolRuleController {

	@Resource
	private RuleService ruleService;


	@PostMapping("/rule")
	public ResponseObj rule() {
		return ResponseObj.success(ruleService.rule());
	}
}
