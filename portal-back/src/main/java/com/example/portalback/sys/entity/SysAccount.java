package com.example.portalback.sys.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "login_time")
    private LocalDateTime loginTime;
    @Basic
    @Column(name = "create_time")
    private LocalDateTime createTime;
    @Basic
    @Column(name = "enabled")
    private Boolean enabled;//是否可用 true/false 是/不是
    @Basic
    @Column(name = "avatar")
    private String avatar;

}
