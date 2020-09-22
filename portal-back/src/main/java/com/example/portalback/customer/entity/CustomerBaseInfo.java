package com.example.portalback.customer.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 账号表
 *
 * @author SONG
 */
@Entity
@Data
@Table(name = "T_CUSTOMER_BASE_INFO")
@DynamicUpdate
public class CustomerBaseInfo {

	@Id
	@GenericGenerator(name = "id", strategy = "uuid")
	@GeneratedValue(generator = "id")
	@Column(name = "id", length = 32)
	private String id;

	@Column(name = "name", length = 32)
	private String name;

	@Column(name = "channel_source", length = 32)
	private String channelSource; // 渠道来源 *客户经理 *本人 * 客户转介

	private String responsible; // 经办客户经理

	@Column(name = "former_name", length = 32)
	private String formerName; // 曾用名

	@Column(name = "id_number", length = 32)
	private String idNumber; // 身份证号

	@Column(name = "sex", length = 32)
	private String sex; // 性别 男 女

	@Column(name = "phone", length = 32)
	private String phone; // 手机号

	@Column(name = "educational", length = 32)
	private String educational; // 学历情况

	@Column(name = "residence_address", length = 32)
	private String residenceAddress; // 户籍地址

	@Column(name = "health_status", length = 32)
	private String healthStatus; // 健康状态

	@Column(name = "account_nature", length = 32)
	private String accountNature; // 户口性质

	@Column(name = "customer_label", length = 32)
	private String customerLabel; // 客户标签

	/**
	 * 家庭信息
	 */

	@Column(name = "marital_status", length = 32)
	private String maritalStatus; // 婚姻状况

	@Column(name = "family_size", length = 32)
	private String familySize; // 家庭人数

	@Column(name = "family_status", length = 32)
	private String familyStatus; // 家庭状况概况

	/**
	 * 居住信息
	 */

	@Column(name = "residential_address", length = 32)
	private String residentialAddress; // 居住地址

	@Column(name = "address", length = 32)
	private String address; // 详细地址

	/**
	 * 个人出租房屋（租房）；
	 * 个人自购（自建）房屋；
	 * 直系亲属自购（自建）房屋；
	 * 亲友自购（自建）房屋；
	 * 单位、学校宿舍或单位、学校自购（自建）房屋；
	 * 单位、学校租赁的出租房屋。
	 */
	@Column(name = "residence_status", length = 32)
	private String residenceStatus; // 居住状态

	@Column(length = 32)
	private String lengthOfResidence; // 居住年限

	/**
	 * 就业信息
	 */

	@Column(length = 32)
	private String companyName; // 单位名称

	@Column(length = 32)
	private String workPhone; // 单位电话

	@Column(length = 32)
	private String unitAddress; // 单位地址

	@Column(length = 32)
	private String unitDetailAddress; // 详细地址

	@Column(length = 32)
	private String industryType; // 行业类型

	@Column(length = 32)
	private String profession; // 职业

	@Column(length = 32)
	private String position; // 职务

	@Column(length = 32)
	private String workingYears; // 工作年限

	@Column(length = 32)
	private String annualSalary; // 年薪

	/**
	 * 经济状况
	 */

	@Column(length = 32)
	private String familyMonthlyIncome; // 家庭月收入

	@Column(length = 32)
	private String numberOfDependents; // 抚养人数

	@Column(length = 32)
	private String assetsToLiabilitiesRatio; // 资产与负债比

	@Column(length = 32)
	private String LoanToIncomeRatio; // 收入还贷比

	@Column(length = 32)
	private String averagePersonalIncome; // 个人年平均收入

	@Column(length = 32)
	private String repaymentToIncomeRatio; // 月还款额与月可支配收入比值

	@Column(length = 32)
	private String familyPropertyAssessment; // 家庭财产评估值

	@Column(length = 32)
	private String debtCoverageRatio; // 债务覆盖率

	/**
	 * 信用状况
	 */

	@Column(length = 32)
	private String repaymentRecord; // 还款记录

	@Column(length = 32)
	private String recordsAndYears; // 个人贷款或信用卡记录和年限

	@Column(length = 32)
	private String breachOfContract; // 违约情况

	@Column(length = 32)
	private String overdraftSituation; // 信用卡透支情况等方面的详细调查

	@Column(length = 32)
	private String bankCardSituation; // 银行卡持有情况及银行账户情况

	@Column(length = 32)
	private String creditCardDefault; // 个人贷款或信用卡违约情况

	@Column(length = 32)
	private String judicialRecords; // 公安司法的不良记录

	@Column(length = 32)
	private String creditScore; // 个人信用度评分

}
