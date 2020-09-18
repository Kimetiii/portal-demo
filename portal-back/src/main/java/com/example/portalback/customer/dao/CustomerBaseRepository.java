package com.example.portalback.customer.dao;

import com.example.portalback.customer.entity.CustomerBaseInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author songsenior
 * @date 2020/9/14 15:07
 * @Description:
 */
@Mapper
public interface CustomerBaseRepository extends JpaRepository<CustomerBaseInfo, String>, JpaSpecificationExecutor<CustomerBaseInfo> {

	List<CustomerBaseInfo> findAll();

	CustomerBaseInfo queryAllById(String id);

}
