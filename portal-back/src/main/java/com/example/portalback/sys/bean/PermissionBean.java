package com.example.portalback.sys.bean;

import com.example.portalback.sys.entity.SysPermission;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

/**
 * @author SONG
 */
@Data
@NoArgsConstructor
public class PermissionBean {

	private String id;

	private String parentId;

	private String code;

	private String name;

	//介绍
	private String intro;

	private LocalDateTime createTime;

	private String creator;

	private LocalDateTime editTime;

	private String editor;

	public static PermissionBean formatBean(SysPermission entity) {
		PermissionBean bean = new PermissionBean();
		BeanUtils.copyProperties(entity, bean);
		return bean;
	}

	public static SysPermission formatEntity(PermissionBean bean) {
		SysPermission entity = new SysPermission();
		BeanUtils.copyProperties(bean, entity);
		return entity;
	}
}
