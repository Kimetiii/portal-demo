package com.example.portalback.sys.dao;

import com.example.portalback.sys.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SysRoleRepository extends JpaRepository<SysRole, String> {

    List<SysRole> findAllByIdIn(List<String> ids);

}
