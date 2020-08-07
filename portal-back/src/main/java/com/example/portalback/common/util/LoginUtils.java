package com.example.portalback.common.util;

import org.springframework.security.core.context.SecurityContextHolder;

public class LoginUtils {

    public static <T> T getLoginInfos() {
        T principal = (T) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal;
    }
}
