package com.example.portalback.sys.dao;

import com.example.portalback.sys.entity.SysAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;


@Component
public interface SysAccountRepository extends JpaRepository<SysAccount, String>, JpaSpecificationExecutor<SysAccount> {

    boolean existsUserByUsername(String username);

    SysAccount findUserByUsername(String username);

}
