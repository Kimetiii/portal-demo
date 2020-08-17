package com.example.portalback.sys.core;

import com.example.portalback.base.model.PageModel;
import com.example.portalback.sys.bean.AccountBean;
import com.example.portalback.sys.model.AccountModel;
import com.example.portalback.sys.service.SysAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class SysManager {

    @Autowired
    private SysAccountService sysAccountService;

    public Page<AccountBean> pageAccount(PageModel model) {
        return sysAccountService.pageAccount(model);
    }

    public void loginSuccess(String userId) {
        sysAccountService.loginSuccess(userId);
    }

    public void addAccount(AccountModel model) {
        AccountBean bean = AccountModel.formatBean(model);
        sysAccountService.addAccount(bean);
    }
}
