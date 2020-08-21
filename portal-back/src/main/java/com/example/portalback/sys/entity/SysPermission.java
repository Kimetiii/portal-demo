package com.example.portalback.sys.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 权限表
 *
 * @author SONG
 */
@Entity
@Data
@Table(name = "T_SYS_PERMISSION")
public class SysPermission {
    @Id
    @GenericGenerator(name = "id", strategy = "uuid")
    @GeneratedValue(generator = "id")
    @Column(name = "id", length = 32)
    private String id;

    @Basic
    @Column(name = "parent_id", length = 32)
    private String parentId;

    @Basic
    @Column(name = "code", length = 10)
    private String code;

    @Basic
    @Column(name = "name", length = 10)
    private String name;

    @Basic
    @Column(name = "intro")
    private String intro;

    @Basic
    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Basic
    @Column(name = "creator", length = 32)
    private String creator;

    @Basic
    @Column(name = "edit_time")
    private LocalDateTime editTime;

    @Basic
    @Column(name = "editor", length = 32)
    private String editor;
}
