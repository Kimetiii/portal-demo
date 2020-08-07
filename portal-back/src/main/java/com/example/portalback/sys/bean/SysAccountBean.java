package com.example.portalback.sys.bean;

import com.example.portalback.common.constant.Constant;
import com.example.portalback.sys.entity.SysAccount;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Data
public class SysAccountBean implements UserDetails {

    private String id;
    private String username;
    private String password;
    private String phone;
    private LocalDateTime loginTime;
    private LocalDateTime createTime;
    private boolean enabled;
    private String avatar;

    public static SysAccountBean formatBean(SysAccount entity) {
        SysAccountBean bean = new SysAccountBean();
        BeanUtils.copyProperties(entity, bean);
        bean.setAvatar(Optional.ofNullable(entity.getAvatar()).orElse(Constant.DEFAULT_AVATAR));
        return bean;
    }

    public static SysAccount getEntity(SysAccountBean bean) {
        SysAccount entity = new SysAccount();
        BeanUtils.copyProperties(bean, entity);
        return entity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
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
