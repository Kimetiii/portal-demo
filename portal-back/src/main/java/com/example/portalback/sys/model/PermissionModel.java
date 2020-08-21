package com.example.portalback.sys.model;

import com.example.portalback.sys.bean.PermissionBean;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * 请求体专用模型
 * 权限入参模型
 *
 * @author SONG
 */
@Data
public class PermissionModel {

	// uuid
	private String id;

	// 上级权限 初始默认为0
	private String parentId;

	// 权限代码
	private String code;

	@NotBlank
	private String name;

	// 权限介绍
	private String intro;

	private LocalDateTime createTime;

	private String creator;

	private LocalDateTime editTime;

	private String editor;

	public static PermissionBean formatBean(PermissionModel model) {
		PermissionBean bean = new PermissionBean();
		BeanUtils.copyProperties(model, bean);
		return bean;
	}

}
