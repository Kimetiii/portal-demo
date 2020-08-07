package com.example.portalback.people.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "T_PEOPLE")
public class People {

    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    @Column(name = "id", length = 32)
    private String id;
    @Basic
    @Column(name = "sex", length = 10)
    private String sex;
    @Basic
    @Column(name = "username", length = 50)
    private String username;
    @Basic
    @Column(name = "age", length = 11)
    private Integer age;
    @Basic
    @Column(name = "avatar")
    private String avatar;

}
