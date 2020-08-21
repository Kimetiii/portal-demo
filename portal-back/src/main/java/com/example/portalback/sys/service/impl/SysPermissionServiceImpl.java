package com.example.portalback.sys.service.impl;

import com.example.portalback.common.util.LoginUtils;
import com.example.portalback.sys.bean.AccountBean;
import com.example.portalback.sys.bean.PermissionBean;
import com.example.portalback.sys.bean.RoleBean;
import com.example.portalback.sys.dao.*;
import com.example.portalback.sys.entity.SysInterfaceInfo;
import com.example.portalback.sys.entity.SysPermission;
import com.example.portalback.sys.entity.SysRolePermission;
import com.example.portalback.sys.service.SysPermissionService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author SONG
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {

	@Resource
	private SysPermissionRepository sysPermissionRepository;

	@Resource
	private RolePermissionRepository rolePermissionRepository;

	@Resource
	private SysRoleRepository sysRoleRepository;

	@Resource
	private AccountRoleRepository accountRoleRepository;

	@Resource
	private SysInterfaceInfoRepository sysInterfaceInfoRepository;

	/**
	 * 判断是否有权限
	 *
	 * @param authentication   认证信息
	 * @param targetObject     目标接口
	 * @param targetPermission 目标所需权限
	 * @return boolean
	 */
	@Override
	public boolean hasPermission(Authentication authentication, Object targetObject, Object targetPermission) {

		// 验证当前的用户 是否有访问目标接口的权限
		boolean flag = false;

		// 获取调用接口信息 开发人员写是固定的接口 无需动态增删改

		String targetUrl = targetObject.toString(); // 当前接口的接口url路径

		String permission = targetPermission.toString(); // 当前接口所需要的权限名称
		// 获取登录用户信息
		AccountBean accountBean = (AccountBean) authentication.getPrincipal();

		// 解耦出来一个单独的方法 查询用户是否拥有当前操作权限
		flag = isFlag(flag, targetUrl, accountBean);

		return flag;
	}

	/**
	 * 判断用户是否具有传入的权限
	 *
	 * @param flag        布尔回参
	 * @param variable  验证权限
	 * @param accountBean 验证用户
	 * @return boolean
	 */
	private boolean isFlag(boolean flag, String variable, AccountBean accountBean) {
		List<RoleBean> roleBeanList = accountBean.getAuthorities();
		List<String> list = new ArrayList<>();
		for (RoleBean roleBean : roleBeanList) {
			list.add(roleBean.getId());
		}
		List<SysRolePermission> rolePermissionList = rolePermissionRepository.findAllByRoleIdIn(list);
		List<String> permissionIdList = new ArrayList<>();
		for (SysRolePermission sysRolePermission : rolePermissionList) {
			permissionIdList.add(sysRolePermission.getPermissionId());
		}
		// 根据用户的角色 获取用户所拥有的所有权限
		List<SysPermission> permissionList = sysPermissionRepository.findAllByIdIn(permissionIdList);
		for (SysPermission sysPermission : permissionList) {
			/*	 if (sysPermission.getName().equals(permission)) {
				flag = true;
			}*/
			List<SysInterfaceInfo> interfaceInfos = sysInterfaceInfoRepository.queryAllByPermissionId(sysPermission.getId());
			for (SysInterfaceInfo interfaceInfo : interfaceInfos) {
				if (variable.equals(interfaceInfo.getUrl())) {
					flag = true;
				}
			}
		}
		return flag;
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
		return false;
	}

	/**
	 * 添加权限
	 *
	 * @param permissionBean permissionBean
	 */
	@Override
	public void addPermission(PermissionBean permissionBean) {
		permissionBean.setCreateTime(LocalDateTime.now());
		permissionBean.setCreator(LoginUtils.getUserId());
		permissionBean.setEditor(LoginUtils.getUserId());
		permissionBean.setEditTime(LocalDateTime.now());
		SysPermission sysPermission = PermissionBean.formatEntity(permissionBean);
		try {
			sysPermissionRepository.save(sysPermission);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addInterface4Permission(SysInterfaceInfo sysInterfaceInfo) {
		sysInterfaceInfoRepository.save(sysInterfaceInfo);
	}
}
