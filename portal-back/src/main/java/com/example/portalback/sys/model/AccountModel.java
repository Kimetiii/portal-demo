package com.example.portalback.sys.model;

import com.example.portalback.sys.bean.AccountBean;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * @author LIN
 */
@Data
public class AccountModel {

    private String id;

    @NotBlank
    private String username;

    @Size(min = 6)
    private String password;

    private String phone;

    private LocalDateTime loginTime;

    private LocalDateTime createTime;

    private boolean enabled;

    private String avatar;

    public static AccountBean formatBean(AccountModel model) {
        AccountBean bean = new AccountBean();
        BeanUtils.copyProperties(model, bean);
        return bean;
    }

}
