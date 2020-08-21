package com.example.portalback.sys.core;

import com.example.portalback.base.model.PageModel;
import com.example.portalback.sys.bean.AccountBean;
import com.example.portalback.sys.bean.PermissionBean;
import com.example.portalback.sys.bean.RoleBean;
import com.example.portalback.sys.entity.SysInterfaceInfo;
import com.example.portalback.sys.model.AccountModel;
import com.example.portalback.sys.model.PermissionModel;
import com.example.portalback.sys.model.RoleModel;
import com.example.portalback.sys.service.SysAccountService;
import com.example.portalback.sys.service.SysPermissionService;
import com.example.portalback.sys.service.SysRoleService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class SysManager {

	@Resource
	private SysAccountService sysAccountService;

	@Resource
	private SysPermissionService sysPermissionService;

	@Resource
	private SysRoleService sysRoleService;

	public Page<AccountBean> pageAccount(PageModel model) {
		return sysAccountService.pageAccount(model);
	}

	public void loginSuccess(String userId) {
		sysAccountService.loginSuccess(userId);
	}

	public void addAccount(AccountModel model) {
		AccountBean bean = AccountModel.formatBean(model);
		sysAccountService.addAccount(bean);
	}

	/**
	 * 添加权限
	 *
	 * @param model model
	 */
	public void addPermission(PermissionModel model) {
		PermissionBean permissionBean = PermissionModel.formatBean(model);
		sysPermissionService.addPermission(permissionBean);
	}

	/**
	 * 添加角色
	 *
	 * @param model model
	 */
	public void addRole(RoleModel model) {
		RoleBean roleBean = RoleModel.formatBean(model);
		List<String> list = new ArrayList<>();
		sysRoleService.addRole(roleBean, list);
	}

	public void addInterface4Permission(SysInterfaceInfo sysInterfaceInfo) {
		sysPermissionService.addInterface4Permission(sysInterfaceInfo);
	}
}
