package com.example.portalback.customer.service;

import com.example.portalback.customer.entity.CustomerBaseInfo;
import com.example.portalback.customer.model.CustomerBaseInfoModel;
import com.example.portalback.customer.model.SearchModel;

import java.util.List;

/**
 * @author songsenior
 * @date 2020/9/14 15:01
 * @Description:
 */

public interface CustomerBaseService {

	CustomerBaseInfo save(CustomerBaseInfoModel customerBaseInfoModel);

	List<CustomerBaseInfo> findAllCustomerBase();

	List<CustomerBaseInfo> findAllCustomerBaseByDeleteStatus();

	CustomerBaseInfo getInfoById(String id);

	CustomerBaseInfoModel enforceRules(String ruleName,CustomerBaseInfoModel model);

	List<CustomerBaseInfo> searchCustomerList(SearchModel searchModel);

	void softDeleteById(String id);

}
