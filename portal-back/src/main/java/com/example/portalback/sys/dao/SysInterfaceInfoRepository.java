package com.example.portalback.sys.dao;

import com.example.portalback.sys.entity.SysInterfaceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SysInterfaceInfoRepository extends JpaRepository<SysInterfaceInfo, String> {

	List<SysInterfaceInfo> queryAllByPermissionId(String permissionId);
}
