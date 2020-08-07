package com.example.portalback.people.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "T_RELATIONSHIP_INFO")
public class RelationshipInfo {

    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    @Column(name = "id", length = 32)
    private String id;

    @Basic
    @Column(name = "name", length = 50)
    private String name;

    @Basic
    @Column(name = "add_time")
    private LocalDateTime addTime;

    @Basic
    @Column(name = "remark")
    private String remark;

}
