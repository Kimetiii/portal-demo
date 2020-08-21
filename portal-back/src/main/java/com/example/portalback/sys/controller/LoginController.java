package com.example.portalback.sys.controller;

import com.example.portalback.common.constant.Constant;
import com.example.portalback.common.entity.ResponseObj;
import com.example.portalback.sys.bean.AccountBean;
import com.example.portalback.sys.core.SysManager;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/login")
@RestController
public class LoginController {

	@Resource
	private SysManager sysManager;

	/**
	 * 登录失败返回 401 以及提示信息.
	 *
	 * @return the rest
	 */
	@PostMapping("/failure")
	public ResponseObj loginFailure() {
		return ResponseObj.failure(HttpStatus.UNAUTHORIZED.value(), "登录失败");
	}

	/**
	 * 登录成功后拿到个人信息.
	 *
	 * @return the rest
	 */
	@PostMapping("/success")
	public ResponseObj loginSuccess() {
		// 登录成功后用户的认证信息 UserDetails会存在 安全上下文寄存器 SecurityContextHolder 中
		AccountBean principal =
				(AccountBean) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		// 脱敏
		principal.setPassword(Constant.PROTECT_PWD);
		sysManager.loginSuccess(principal.getId());
		return ResponseObj.success("登录成功");
	}

}
