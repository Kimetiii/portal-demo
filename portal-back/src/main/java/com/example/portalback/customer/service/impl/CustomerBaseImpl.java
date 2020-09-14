package com.example.portalback.customer.service.impl;

import com.example.portalback.customer.dao.CustomerBaseRepository;
import com.example.portalback.customer.entity.CustomerBaseInfo;
import com.example.portalback.customer.model.CustomerBaseInfoModel;
import com.example.portalback.customer.service.CustomerBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author songsenior
 * @date 2020/9/14 15:03
 * @Description:
 */
@Service
public class CustomerBaseImpl implements CustomerBaseService {

	@Resource
	private CustomerBaseRepository customerBaseRepository;

	@Override
	public CustomerBaseInfo save(CustomerBaseInfoModel customerBaseInfoModel) {
		CustomerBaseInfo customerBaseInfo = CustomerBaseInfoModel.formatEntity(customerBaseInfoModel);
		CustomerBaseInfo save = customerBaseRepository.save(customerBaseInfo);
		return save;
	}
}
