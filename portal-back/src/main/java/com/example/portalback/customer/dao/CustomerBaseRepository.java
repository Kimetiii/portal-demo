package com.example.portalback.customer.dao;

import com.example.portalback.customer.entity.CustomerBaseInfo;
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

	@Query(value = "select *\n" +
			"from t_customer_base_info\n" +
			"where channel_source = ?1\n" +
			"   or id = ?2\n" +
			"   or name = ?3", nativeQuery = true)
	List<CustomerBaseInfo> searchCustomerList(String channelSource, String customerId, String customerName, String idNumber, String responsible);

}
