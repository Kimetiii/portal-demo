package com.example.portalback.drools.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 数据库的规则结构
 */
@Data
@Entity
@DynamicUpdate
@Table(name = "ACTIVITY_RULE")
public class ActivityRuleEntity {

	@Id
	@GenericGenerator(name = "id", strategy = "uuid")
	@GeneratedValue(generator = "id")
	@Column(name = "id", length = 32)
	private String id;

	private Long taskId;

	private String ruleName;

	private String event;

	private String ruleValue;

	private Double score;

	private Byte priority;

	private Byte awardeeType;

	private Byte sendAwardTimes;

	private String createBy;

	private Date createTime;

	private String updateBy;

	private Date updateTime;

	private String isDelete;

	private String isSmsNotice;

}