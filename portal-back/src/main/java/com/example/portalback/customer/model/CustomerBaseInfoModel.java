package com.example.portalback.customer.model;

import lombok.Data;

/**
 * @author SONG
 * @date 2020/9/9 14:14
 * @Description: 客户信息入参模型
 */
@Data
public class CustomerBaseInfoModel {

	/**
	 * 基本信息
	 */

	private String id;

	private String name;

	private String channelSource; // 渠道来源

	private String formerName; // 曾用名

	private String idNumber; // 身份证号

	private String sex; // 性别

	private String phone; // 手机号

	private String educational; // 学历情况

	private String residenceAddress; // 户籍地址

	private String healthStatus; // 健康状态

	private String accountNature; // 户口性质

	private String customerLabel; // 客户标签

	/**
	 * 家庭信息
	 */

	private String maritalStatus; // 婚姻状况

	private String familySize; // 家庭人数

	private String summaryOfFamilyStatus; // 家庭状况概况

	/**
	 * 居住信息
	 */

	private String residentialAddress; // 居住地址

	private String address; // 详细地址

	private String residenceStatus; // 居住状态

	private String lengthOfResidence; // 居住年限

	/**
	 * 就业信息
	 */

	private String companyName; // 单位名称

	private String workPhone; // 单位电话

	private String unitAddress; // 单位地址

	private String unitDetailAddress; // 详细地址

	private String industryType; // 行业类型

	private String profession; // 职业

	private String position; // 职务

	private String workingYears; // 工作年限

	private String annualSalary; // 年薪
}
