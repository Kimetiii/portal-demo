package com.example.portalback.drools.model;

import com.example.portalback.annotation.Fact;
import com.example.portalback.drools.domain.enums.ActivityEvent;
import lombok.Data;

/**
 * @author songsenior
 * @date 2020/9/25 11:23
 * @Description: 规则 fact 剥离出需要 LHS 的参数
 */
@Data
@Fact(ActivityEvent.CUSTOMER)
public class CustomerFact {

	public static final String EDUCATION_1 = "专科以下";
	public static final String EDUCATION_2 = "专科";
	public static final String EDUCATION_3 = "本科";
	public static final String EDUCATION_4 = "本科以上";


	private String id;

	private Integer age; // 解析身份证信息得出

	private String educational;

	private String healthStatus;



	private String maritalStatus; // 婚姻状况

	private String familySize; // 家庭人数

	private Integer workingYears; // 工作年限

	private Double annualSalary; // 年薪

	private Double familyMonthlyIncome; // 家庭月收入

	private Integer numberOfDependents; // 抚养人数

	private Double creditScore;

}
