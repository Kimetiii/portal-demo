package com.example.portalback.sys.service;

import com.example.portalback.sys.bean.RoleBean;

import java.util.List;

/**
 * @author LIN
 */
public interface SysRoleService {

	void addRole(RoleBean roleBean, List<String> permissionList);

	void addPermission4Role(String roleId,String permissionId);

}
