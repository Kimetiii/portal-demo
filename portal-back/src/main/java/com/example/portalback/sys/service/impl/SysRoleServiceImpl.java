package com.example.portalback.sys.service.impl;

import com.example.portalback.common.util.LoginUtils;
import com.example.portalback.sys.bean.RoleBean;
import com.example.portalback.sys.dao.RolePermissionRepository;
import com.example.portalback.sys.dao.SysRoleRepository;
import com.example.portalback.sys.entity.SysRole;
import com.example.portalback.sys.entity.SysRolePermission;
import com.example.portalback.sys.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author LINs
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Resource
	private SysRoleRepository sysRoleRepository;

	@Resource
	private RolePermissionRepository rolePermissionRepository;

	/**
	 * 添加角色 插入系统数据
	 *
	 * @param roleBean roleBean
	 */
	@Override
	public void addRole(RoleBean roleBean, List<String> permissionList) {
		roleBean.setCreator(LoginUtils.getUserName());
		roleBean.setCreateTime(LocalDateTime.now());
		roleBean.setEditor(LoginUtils.getUserName());
		roleBean.setEditTime(LocalDateTime.now());
		SysRole entity = RoleBean.formatEntity(roleBean);
		SysRole role = sysRoleRepository.save(entity);
		if (permissionList.size() > 0) {
			for (String permissionId : permissionList) {
				addPermission4Role(role.getId(), permissionId);
			}
		}
	}

	/**
	 * 给角色赋权
	 *
	 * @param roleId roleId
	 * @param permissionId permissionId
	 */
	@Override
	public void addPermission4Role(String roleId, String permissionId) {
		SysRolePermission sysRolePermission = new SysRolePermission();
		sysRolePermission.setRoleId(roleId);
		sysRolePermission.setPermissionId(permissionId);
		sysRolePermission.setCreator(LoginUtils.getUserName());
		sysRolePermission.setCreateTime(LocalDateTime.now());
		rolePermissionRepository.save(sysRolePermission);
	}
}
