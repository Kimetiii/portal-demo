package com.example.portalback.sys.service;

import com.example.portalback.base.model.PageModel;
import com.example.portalback.sys.bean.AccountBean;
import com.example.portalback.sys.bean.RoleBean;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * 处理用户信息业务层
 *
 * @author SONG
 */
public interface SysAccountService extends UserDetailsService {

	/**
	 * 获取账号的角色
	 *
	 * @param accountId accountId
	 * @return list
	 */
	List<RoleBean> getAccountRoles(String accountId);

	/**
	 * page
	 *
	 * @param model model
	 * @return page
	 */
	Page<AccountBean> pageAccount(PageModel model);

	/**
	 * 登录成功
	 *
	 * @param userId userId
	 */
	void loginSuccess(String userId);

	/**
	 * 添加账号
	 *
	 * @param bean bean
	 */
	void addAccount(AccountBean bean);

	void delAccount(String userId);
}
