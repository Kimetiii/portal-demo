package com.example.portalback.sys.model;

import com.example.portalback.sys.bean.RoleBean;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

/**
 * 请求体专用模型
 * 权限入参模型
 *
 * @author SONG
 */
@Data
public class RoleModel {

	private String id;

	private String parentId;

	private String code;

	private String name;

	//ROLE_name
	private String authority;

	private String intro;

	private LocalDateTime createTime;

	private String creator;

	private LocalDateTime editTime;

	private String editor;


	public static RoleBean formatBean(RoleModel model) {
		RoleBean bean = new RoleBean();
		BeanUtils.copyProperties(model, bean);
		return bean;
	}

}
