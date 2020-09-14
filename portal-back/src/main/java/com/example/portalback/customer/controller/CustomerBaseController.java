package com.example.portalback.customer.controller;

import com.example.portalback.common.entity.ResponseObj;
import com.example.portalback.customer.model.CustomerBaseInfoModel;
import com.example.portalback.customer.service.CustomerBaseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author songsenior
 * @date 2020/9/14 15:37
 * @Description:
 */
@RequestMapping("customerBase")
@RestController
public class CustomerBaseController {

	@Resource
	private CustomerBaseService customerBaseService;

	@PostMapping("addCustomer")
	public ResponseObj addCustomer(@RequestBody CustomerBaseInfoModel model) {
		try {
			return ResponseObj.success(customerBaseService.save(model), "insert success");
		} catch (Exception e) {
			return ResponseObj.failure(e);
		}
	}
}
