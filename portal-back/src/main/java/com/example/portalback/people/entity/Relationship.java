package com.example.portalback.people.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "T_RELATIONSHIP")
public class Relationship {

    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    @Column(name = "id", length = 32)
    private String id;
    @Basic
    @Column(name = "master_id", length = 32)
    private String masterId;//主
    @Basic
    @Column(name = "servant_id", length = 32)
    private String servantId;//从
    @Basic
    @Column(name = "relationship_info_id", length = 32)
    private String relationshipInfoId;//关系信息id

}
