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
    public List<CustomerBaseInfo> findAllCustomerBaseByDeleteStatus() {

        return customerBaseRepository.findAllByDeleteStatus();
    }

    @Override
	public CustomerBaseInfo getInfoById(String id) {
		return customerBaseRepository.queryAllById(id);
	}

	/**
	 * 执行规则业务层接口
	 *
	 * @param ruleName 执行的规则名称
	 * @param model    被执行的fact
	 * @return 需要返回执行结果
	 */
	@Override
	public CustomerBaseInfo enforceRules(String ruleName, CustomerBaseInfoModel model) {
		CustomerBaseInfo customerBaseInfo = CustomerBaseInfoModel.formatEntity(model);

		KieSession kieSession = kieTemplate.getKieSession("客户规则"+".drl");
		kieSession.insert(customerBaseInfo);
		kieSession.fireAllRules();
		System.err.println(customerBaseInfo.getCreditScore());

		return customerBaseInfo;
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

    @Override
    public void softDeleteById(String id) {
        customerBaseRepository.softDeleteById(id);
    }


}
