package com.example.portalback.common.config;

import com.example.portalback.sys.bean.SysAccountBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class CustomLogoutHandler implements LogoutHandler {

    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
        SysAccountBean account = (SysAccountBean) authentication.getPrincipal();
        String username = account.getUsername();
        log.info("username: {}  is offline now", username);
    }
}
