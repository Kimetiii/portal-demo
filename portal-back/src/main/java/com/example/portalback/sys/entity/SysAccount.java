package com.example.portalback.sys.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 账号表
 *
 * @author SONG
 */
@Entity
@Data
@Table(name = "T_SYS_ACCOUNT")
@DynamicUpdate
public class SysAccount {

    @Id
    @GenericGenerator(name = "id", strategy = "uuid")
    @GeneratedValue(generator = "id")
    @Column(name = "id", length = 32)
    private String id;

    @Basic
    @Column(name = "username", length = 12)
    private String username;

	@Basic
	@Column(name = "mail_address", length = 200)
	private String mailAddress;

	@Basic
	@Column(name = "department", length = 32)
	private String department;

    @Basic
    @Column(name = "password", length = 32)
    private String password;

    @Basic
    @Column(name = "phone", length = 20)
    private String phone;

    @Basic
    @Column(name = "login_time")
    private LocalDateTime loginTime;

    @Basic
    @Column(name = "create_time")
    private LocalDateTime createTime;

    //是否可用 true/false 是/不是
    @Basic
    @Column(name = "enabled")
    private Boolean enabled;

    @Basic
    @Column(name = "avatar")
    private String avatar;

    @Basic
    @Column(name = "intro")
    private String intro;

	@Basic
	@Column(name = "del_flag", length = 12)
	private String delFlag;
}
