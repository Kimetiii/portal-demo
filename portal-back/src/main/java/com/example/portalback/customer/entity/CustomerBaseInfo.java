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
@Table(name = "CUSTOMER_BASE_INFO")
@DynamicUpdate
public class CustomerBaseInfo {

	@Id
	@GenericGenerator(name = "id", strategy = "uuid")
	@GeneratedValue(generator = "id")
	@Column(name = "id", length = 32)
	private String id;

	@Basic
	@Column(name = "channel_source", length = 32)
	private String channelSource;

	/**
	 * 基本信息
	 */

	private String name;

	private String formerName;

	private String idNumber;

	private String sex;

	private String phone;

	private String educational;

	private String residenceAddress;

	private String healthStatus;

	private String accountNature;

	private String customerLabel;

	/**
	 * 家庭信息
	 */

	private String maritalStatus;

	private String familySize;

	private String summaryOfFamilyStatus;

	/**
	 * 居住信息
	 */

	private String residentialAddress;

	private String address;

	private String residenceStatus;

	private String lengthOfResidence;

	/**
	 * 就业信息
	 */

	private String companyName;

	private String workPhone;

	private String unitAddress;

	private String unitDetailAddress;

	private String industryType;

	private String profession;

	private String position;

	private String workingYears;

	private String annualSalary;


}
