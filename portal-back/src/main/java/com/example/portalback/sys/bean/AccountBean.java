package com.example.portalback.sys.bean;

import com.example.portalback.common.constant.Constant;
import com.example.portalback.sys.entity.SysAccount;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author LIN
 */
@Data
public class AccountBean implements UserDetails {

    private String id;

    private String username;

    private String password;

    private String phone;

    private LocalDateTime loginTime;

    private LocalDateTime createTime;

    private boolean enabled;

    private String avatar;

    private List<RoleBean> authorities;

    public static AccountBean formatBean(SysAccount entity, List<RoleBean> authorities) {
        AccountBean bean = new AccountBean();
        BeanUtils.copyProperties(entity, bean);
        bean.setAvatar(Optional.ofNullable(entity.getAvatar()).orElse(Constant.DEFAULT_AVATAR));
        bean.setAuthorities(authorities);
        return bean;
    }

    public static SysAccount getEntity(AccountBean bean) {
        SysAccount entity = new SysAccount();
        BeanUtils.copyProperties(bean, entity);
        return entity;
    }

    @Override
    public List<RoleBean> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

}
