package com.example.portalback.sys.model;

import com.example.portalback.sys.bean.AccountBean;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * 请求体专用模型
 *
 * @author SONG
 */
@Data
public class AccountModel {

	private String id;

	@NotBlank
	private String username;

	@Size(min = 6)
	private String password;

	private String mailAddress;

	private String department;

	private String phone;

	private LocalDateTime loginTime;

	private LocalDateTime createTime;

	private boolean enabled;

	private String avatar; // 头像

	private String intro;

	private String deFlag;

	/**
	 * 内置一个转换bean类型的方法 浅拷贝
	 *
	 * @param model model
	 * @return AccountBean
	 */
	public static AccountBean formatBean(AccountModel model) {
		AccountBean bean = new AccountBean();
		BeanUtils.copyProperties(model, bean);
		return bean;
	}

}
