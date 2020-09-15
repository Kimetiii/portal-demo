package com.example.portalback.customer.service;

import com.example.portalback.customer.entity.CustomerBaseInfo;
import com.example.portalback.customer.model.CustomerBaseInfoModel;

/**
 * @author songsenior
 * @date 2020/9/14 15:01
 * @Description:
 */

public interface CustomerBaseService {

	CustomerBaseInfo save(CustomerBaseInfoModel customerBaseInfoModel);

	CustomerBaseInfoModel enforceRules(String ruleName,CustomerBaseInfoModel model);
}
