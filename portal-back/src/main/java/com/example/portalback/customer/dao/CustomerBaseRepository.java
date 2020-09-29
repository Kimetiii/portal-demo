package com.example.portalback.customer.dao;

import com.example.portalback.customer.entity.CustomerBaseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * @author songsenior
 * @date 2020/9/14 15:07
 * @Description:
 */
@Mapper
public interface CustomerBaseRepository extends JpaRepository<CustomerBaseInfo, String>, JpaSpecificationExecutor<CustomerBaseInfo> {

	List<CustomerBaseInfo> findAll();

	@Query(value = "select *\n" +
			" from t_customer_base_info\n" +
			" where delete_status = 0 " ,nativeQuery = true)
	List<CustomerBaseInfo> findAllByDeleteStatus();


	CustomerBaseInfo queryAllById(String id);

	@Query(value = "select *\n" +
			"from t_customer_base_info\n" +
			"where (channel_source = ?1\n" +
			"   or id = ?2\n" +
			"   or name = ?3\n"+
			"   or id_number = ?4\n"+
			"   or responsible = ?5\n)"+
			"	and  delete_status = 0 ", nativeQuery = true)
	List<CustomerBaseInfo> searchCustomerList(String channelSource, String customerId, String customerName, String idNumber, String responsible);

	@Transactional
	@Modifying
	@Query(value = "update t_customer_base_info\n"+
			"set delete_status = 1\n"+
			"where id = ?1", nativeQuery = true)
	int softDeleteById(String id);


}
