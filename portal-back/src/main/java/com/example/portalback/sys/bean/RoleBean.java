package com.example.portalback.sys.bean;

import com.example.portalback.sys.entity.SysRole;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDateTime;

/**
 * @author LIN
 * 授权bean
 */
@Data
@NoArgsConstructor
public class RoleBean implements GrantedAuthority {

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

    public static RoleBean formatBean(SysRole entity) {
        RoleBean bean = new RoleBean();
        BeanUtils.copyProperties(entity, bean);
        bean.setAuthority("ROLE_" + entity.getName());
        return bean;
    }

    public static SysRole formatEntity(RoleBean bean){
    	SysRole entity=new SysRole();
		BeanUtils.copyProperties(bean,entity);
		return entity;
	}

    public static String getAuthority(SysRole entity) {
        return "ROLE_" + entity.getName();
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
