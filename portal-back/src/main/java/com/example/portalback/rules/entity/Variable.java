package com.example.portalback.rules.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 规则变量表 保存规则的所有变量
 */
@Data
@Entity
@Table(name = "T_VARIABLE")
public class Variable {
	@Id
	@GeneratedValue(generator = "uuidGenerator")
	@GenericGenerator(name = "uuidGenerator", strategy = "uuid")
	@Column(name = "id", length = 32)
	private String id;



}
