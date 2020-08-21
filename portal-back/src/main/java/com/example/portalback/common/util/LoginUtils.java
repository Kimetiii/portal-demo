package com.example.portalback.common.util;

import com.example.portalback.sys.bean.AccountBean;
import org.springframework.security.core.context.SecurityContextHolder;

public class LoginUtils {

	public static <T> T getLoginInfos() {
		T principal = (T) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return principal;
	}

	public static String getUserId() {
		AccountBean accountBean = (AccountBean) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return accountBean.getId();
	}

	public static String getUserName(){
		AccountBean accountBean = (AccountBean) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return accountBean.getUsername();
	}
}
