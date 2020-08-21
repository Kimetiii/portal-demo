package com.example.portalback.sys.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author SONG
 */
@Entity
@Data
@Table(name = "T_INTERFACE_INFO")
public class SysInterfaceInfo {

	@Id
	@GenericGenerator(name = "id", strategy = "uuid")
	@GeneratedValue(generator = "id")
	@Column(name = "id", length = 32)
	private String id;

	@Basic
	@Column(name = "permission_id")
	private String permissionId;

	@Basic
	@Column(name = "url")
	private String url;

	@Basic
	@Column(name = "introduction")
	private String introduction;

}
