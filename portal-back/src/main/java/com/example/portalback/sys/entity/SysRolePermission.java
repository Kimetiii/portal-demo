package com.example.portalback.sys.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 角色-权限关联表
 *
 * @author LIN
 */
@Entity
@Data
@Table(name = "T_ROLE_PERMISSION")
public class SysRolePermission {
    @Id
    @GenericGenerator(name = "id", strategy = "uuid")
    @GeneratedValue(generator = "id")
    @Column(name = "id", length = 32)
    private String id;

    @Basic
    @Column(name = "role_id", length = 32)
    private String roleId;

    @Basic
    @Column(name = "permission_id", length = 32)
    private String permissionId;

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
