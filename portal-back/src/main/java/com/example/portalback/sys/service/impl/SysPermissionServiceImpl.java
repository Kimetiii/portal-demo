package com.example.portalback.sys.service.impl;

import com.example.portalback.sys.bean.AccountBean;
import com.example.portalback.sys.dao.AccountRoleRepository;
import com.example.portalback.sys.dao.RolePermissionRepository;
import com.example.portalback.sys.dao.SysPermissionRepository;
import com.example.portalback.sys.dao.SysRoleRepository;
import com.example.portalback.sys.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author LIN
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionRepository sysPermissionRepository;

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    @Autowired
    private SysRoleRepository sysRoleRepository;

    @Autowired
    private AccountRoleRepository accountRoleRepository;

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

        String targetUrl = targetObject.toString();
        AccountBean accountBean = (AccountBean) authentication.getDetails();


        return true;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}
