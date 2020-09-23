package com.example.portalback.customer.controller;

import com.example.portalback.common.entity.ResponseObj;
import com.example.portalback.customer.entity.CustomerBaseInfo;
import com.example.portalback.customer.model.CustomerBaseInfoModel;
import com.example.portalback.customer.model.SearchModel;
import com.example.portalback.customer.service.CustomerBaseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

	@GetMapping("findAllCustomer")
	public ResponseObj findAllCustomer() {
		try {
			List<CustomerBaseInfo> allCustomerBase = customerBaseService.findAllCustomerBase();
			return ResponseObj.success(allCustomerBase);
		} catch (Exception e) {
			return ResponseObj.failure(e);
		}
	}

	@PostMapping("getCustomerById")
	public ResponseObj getCustomerById(@RequestParam String id) {
		try {
			CustomerBaseInfo infoById = customerBaseService.getInfoById(id);
			return ResponseObj.success(infoById,"success");
		} catch (Exception e) {
			return ResponseObj.failure(e);
		}
	}

	@PostMapping("enforceRules")
	public ResponseObj enforceRules(@RequestBody CustomerBaseInfoModel model) {
		try {
			return ResponseObj.success(customerBaseService.enforceRules(null, model), "insert success");
		} catch (Exception e) {
			return ResponseObj.failure(e);
		}
	}

	@PostMapping("searchCustomerList")
	public ResponseObj searchCustomerList(@RequestBody SearchModel searchModel) {
		try {
			List<CustomerBaseInfo> customerBaseInfos = customerBaseService.searchCustomerList(searchModel);
			return ResponseObj.success(customerBaseInfos);
		} catch (Exception e) {
			return ResponseObj.failure(e);
		}
	}

}
