package com.example.portalback.sys.service;

import com.example.portalback.sys.bean.PermissionBean;
import com.example.portalback.sys.entity.SysInterfaceInfo;
import org.springframework.security.access.PermissionEvaluator;

/**
 * @author LIN
 */
public interface SysPermissionService extends PermissionEvaluator {

	void addPermission(PermissionBean permissionBean);

	void addInterface4Permission(SysInterfaceInfo sysInterfaceInfo);
}
