package com.example.portalback.drools.model;

import lombok.Data;

/**
 * @author songsenior
 * @date 2020/7/30 09:44
 * @Description: factInfo
 */
@Data
public class CreditCardApplyInfo {

	public static final String EDUCATION_1 = "专科以下";
	public static final String EDUCATION_2 = "专科";
	public static final String EDUCATION_3 = "本科";
	public static final String EDUCATION_4 = "本科以上";

	private String name; // 姓名

	private String sex; // 性别

	private String education; // 学历

	private String telephone; // 电话

	private double monthlyIncome = 0; // 月收入

	private String address; // 住址

	private boolean hasHouse = false; // 是否有房
	private boolean hasCar = false; // 是否有车
	private int hasCreditCardCount = 0; // 持有信用卡的数量

	private boolean checkResult = true; // 是否审核通过
	private double quota = 0; // 额度
	private int score = 0; // 模型分数
	private String modelName; // 模型名称

	@Override
	public String toString() {
		if (checkResult) {
			return "审核通过，信用卡额度为：" + quota;
		}
		return "审核不通过！";
	}
}
