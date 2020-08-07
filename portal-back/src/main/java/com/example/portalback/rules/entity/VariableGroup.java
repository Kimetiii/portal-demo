package com.example.portalback.rules.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 规则变量分组表 保存规则的所有变量分组
 */
@Data
@Entity
@Table(name = "T_VARIABLE_GROUP")
public class VariableGroup {
	@Id
	@GeneratedValue(generator = "uuidGenerator")
	@GenericGenerator(name = "uuidGenerator", strategy = "uuid")
	@Column(name = "id", length = 32)
	private String id;



}
