package com.example.portalback.ledger.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "T_LEDGER")
public class Ledger {
	@Id
	@GeneratedValue(generator = "uuidGenerator")
	@GenericGenerator(name = "uuidGenerator", strategy = "uuid")
	@Column(name = "id", length = 32)
	private String id;

	@Basic
	@Column(name = "group_id", length = 32)
	private String groupId;

	@Basic
	@Column(name = "content", length = 250)
	private String content;

	@Basic
	@Column(name = "subject", length = 20)
	private String subject;

	@Basic
	@Column(name = "amount", length = 20)
	private String amount;

	@Basic
	@Column(name = "record_time")
	private LocalDate recordTime;

	@Basic
	@Column(name = "create_time")
	private LocalDateTime createTime;

	@Basic
	@Column(name = "update_time")
	private LocalDateTime updateTime;

}
