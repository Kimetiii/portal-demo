package com.example.portalback.sys.dao;

import com.example.portalback.sys.entity.SysAccountRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRoleRepository extends JpaRepository<SysAccountRole, String> {

    List<SysAccountRole> findAllByAccountId(String accountId);

}
