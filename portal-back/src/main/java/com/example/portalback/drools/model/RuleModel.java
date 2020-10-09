package com.example.portalback.drools.model;

import lombok.Data;

/**
 * @author songsenior
 * @date 2020/9/29 10:32
 * @Description:
 */
@Data
public class RuleModel {

	private String id;

	private String ruleName;

	private String ruleValue;

	private String event;

	private Double score;


}
