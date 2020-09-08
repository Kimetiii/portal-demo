package com.example.portalback.product.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 账号表
 *
 * @author SONG
 */
@Entity
@Data
@Table(name = "T_FINANCIAL_PRODUCT")
@DynamicUpdate
public class FinancialProduct {

    @Id
    @GenericGenerator(name = "id", strategy = "uuid")
    @GeneratedValue(generator = "id")
    @Column(name = "id", length = 32)
    private String id;

    @Basic
    @Column(name = "product_name", length = 32)
    private String productName;



}
