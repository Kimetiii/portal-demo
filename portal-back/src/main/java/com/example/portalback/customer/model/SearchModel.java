package com.example.portalback.customer.model;

import lombok.Data;

/**
 * @author songsenior
 * @date 2020/9/19 11:05
 * @Description:
 */
@Data
public class SearchModel {

	private String channelSource; // 客户来源

	private String customerName; // 客户姓名

	private String idNumber; // 证件号码

	private String customerId; // 客户号

	private String responsible; // 经办客户经理

}
