package com.example.portalback.sys.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author LIN
 */
@Entity
@Data
@Table(name = "T_ACCOUNT_ROLE")
public class SysAccountRole {

    @Id
    @GenericGenerator(name = "id", strategy = "uuid")
    @GeneratedValue(generator = "id")
    @Column(name = "id", length = 32)
    private String id;

    @Basic
    @Column(name = "account_id", length = 32)
    private String accountId;

    @Basic
    @Column(name = "role_id", length = 32)
    private String roleId;

    @Basic
    @Column(name = "creator", length = 32)
    private String creator;

    @Basic
    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Basic
    @Column(name = "editor", length = 32)
    private String editor;

    @Basic
    @Column(name = "edit_time")
    private LocalDateTime editTime;

}
