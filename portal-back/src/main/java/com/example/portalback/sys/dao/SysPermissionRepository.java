package com.example.portalback.sys.dao;

import com.example.portalback.sys.entity.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SysPermissionRepository extends JpaRepository<SysPermission, String> {

    List<SysPermission> findAllByIdIn(List<String> ids);

}
