package com.example.portalback.sys.dao;

import com.example.portalback.sys.entity.SysRolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RolePermissionRepository extends JpaRepository<SysRolePermission, String> {

    List<SysRolePermission> findAllByRoleIdIn(List<String> roleIds);

}
