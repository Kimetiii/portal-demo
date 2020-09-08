package com.example.portalback.contract.entity;

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
@Table(name = "T_ELECTRONIC_CONTRACT")
@DynamicUpdate
public class ElectronicContract {

	@Id
	@GenericGenerator(name = "id", strategy = "uuid")
	@GeneratedValue(generator = "id")
	@Column(name = "id", length = 32)
	private String id;

	@Basic
	@Column(name = "contract_name", length = 32)
	private String contractName;

	@Basic
	@Column(name = "contract_type", length = 32)
	private String contractType;

	@Basic
	@Column(name = "number", length = 32)
	private String number;





}
