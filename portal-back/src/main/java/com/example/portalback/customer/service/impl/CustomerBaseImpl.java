package com.example.portalback.customer.service.impl;

import com.drools.core.KieTemplate;
import com.example.portalback.customer.dao.CustomerBaseRepository;
import com.example.portalback.customer.entity.CustomerBaseInfo;
import com.example.portalback.customer.model.CustomerBaseInfoModel;
import com.example.portalback.customer.model.SearchModel;
import com.example.portalback.customer.service.CustomerBaseService;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author songsenior
 * @date 2020/9/14 15:03
 * @Description:
 */
@Service
public class CustomerBaseImpl implements CustomerBaseService {

	@Resource
	KieTemplate kieTemplate;

	@Resource
	private CustomerBaseRepository customerBaseRepository;

	@Override
	public CustomerBaseInfo save(CustomerBaseInfoModel customerBaseInfoModel) {
		CustomerBaseInfo customerBaseInfo = CustomerBaseInfoModel.formatEntity(customerBaseInfoModel);
		CustomerBaseInfo save = customerBaseRepository.save(customerBaseInfo);
		return save;
	}

	@Override
	public List<CustomerBaseInfo> findAllCustomerBase() {
		return customerBaseRepository.findAll();
	}

	@Override
	public CustomerBaseInfo getInfoById(String id) {
		return customerBaseRepository.queryAllById(id);
	}

	@Override
	public CustomerBaseInfoModel enforceRules(String ruleName, CustomerBaseInfoModel model) {
		KieSession kieSession = kieTemplate.getKieSession("demo.drl");
		kieSession.insert(model);
		kieSession.fireAllRules();
		System.err.println(model.getCreditScore());
		return model;
	}

	/**
	 * 按需 模糊搜索
	 *
	 * @param searchModel searchModel
	 * @return list
	 */
	@Override
	public List<CustomerBaseInfo> searchCustomerList(SearchModel searchModel) {
		String channelSource = searchModel.getChannelSource();
		String customerId = searchModel.getCustomerId();
		String customerName;
		customerName = searchModel.getCustomerName();
		String idNumber = searchModel.getIdNumber();
		String responsible = searchModel.getResponsible();

		List<CustomerBaseInfo> customerBaseInfos = customerBaseRepository.searchCustomerList(channelSource, customerId, customerName, idNumber, responsible);
		return customerBaseInfos;
	}

}
