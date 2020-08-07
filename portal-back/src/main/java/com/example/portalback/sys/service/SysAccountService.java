package com.example.portalback.sys.service;

import com.example.portalback.base.model.PageModel;
import com.example.portalback.sys.bean.SysAccountBean;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface SysAccountService extends UserDetailsService {

    Page<SysAccountBean> pageAccount(PageModel model);

    SysAccountBean getAccount(String userId);

    void loginSuccess(String userId);

    void addAccount(SysAccountBean bean);
}
