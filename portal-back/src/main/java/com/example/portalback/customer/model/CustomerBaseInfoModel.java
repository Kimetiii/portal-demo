package com.example.portalback.customer.model;

import com.example.portalback.customer.entity.CustomerBaseInfo;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @author SONG
 * @date 2020/9/9 14:14
 * @Description: 客户信息入参模型
 */
@Data
public class CustomerBaseInfoModel {

	private boolean isBlackList;

	private boolean isWhiteList;
	/**
	 * 基本信息
	 */

	private String id;

	private String name;

	private String channelSource; // 渠道来源

	private String responsible; // 经办客户经理

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

	private String maritalStatus; // 婚姻状况 0 未婚 1 已婚

	private String familySize; // 家庭人数

	private String summaryOfFamilyStatus; // 家庭状况概况

	/**
	 * 居住信息
	 */

	private String residentialAddress; // 居住地址

	private String detailedAddress; // 详细地址

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

	private Double annualSalary; // 年薪

	/**
	 * 经济状况
	 */
	private Double familyMonthlyIncome; // 家庭月收入

	private Integer numberOfDependents; // 抚养人数

	private String assetsToLiabilitiesRatio; // 资产与负债比

	private String LoanToIncomeRatio; // 收入还贷比

	private String averagePersonalIncome; // 个人年平均收入

	private String repaymentToIncomeRatio; // 月还款额与月可支配收入比值

	private String familyPropertyAssessment; // 家庭财产评估值

	private String debtCoverageRatio; // 债务覆盖率

	/**
	 * 信用状况
	 */

	private String repaymentRecord; // 还款记录

	private String recordsAndYears; // 个人贷款或信用卡记录和年限

	private String breachOfContract; // 违约情况

	private String overdraftSituation; // 信用卡透支情况等方面的详细调查

	private String bankCardSituation; // 银行卡持有情况及银行账户情况

	private String creditCardDefault; // 个人贷款或信用卡违约情况

	private String judicialRecords; // 公安司法的不良记录

	private Double creditScore; // 个人信用度评分


	public static CustomerBaseInfo formatEntity(CustomerBaseInfoModel customerBaseInfoModel) {
		CustomerBaseInfo customerBaseInfo = new CustomerBaseInfo();
		BeanUtils.copyProperties(customerBaseInfoModel, customerBaseInfo);
		return customerBaseInfo;
	}

}
