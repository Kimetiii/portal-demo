package com.example.portalback.drools.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 数据库的规则结构
 */
@Data
@Entity
@Table(name = "ACTIVITY_RULE")
public class ActivityRuleEntity {

	@Id
	@GeneratedValue(generator = "uuidGenerator")
	@GenericGenerator(name = "uuidGenerator", strategy = "uuid")
	private Integer id;

	private Long taskId;

	private String event;

	private String ruleValue;

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