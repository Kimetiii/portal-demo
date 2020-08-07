package com.example.portalback.sys.dao;

import com.example.portalback.sys.entity.SysAccount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;


@SpringBootTest
class SysAccountRepositoryTest {

    @Autowired
    private SysAccountRepository sysAccountRepository;

    @Test
    void name() {

        SysAccount sysAccount = new SysAccount();

        sysAccount.setEnabled(true);
        sysAccount.setCreateTime(LocalDateTime.now());
        sysAccount.setPassword("123456");
        sysAccount.setUsername("admin");
        sysAccount.setPhone("13798776775");
        sysAccountRepository.save(sysAccount);

    }
}
