package com.example.portalback.sys.controller;

import com.example.portalback.base.model.PageModel;
import com.example.portalback.common.constant.Constant;
import com.example.portalback.common.entity.ResponseObj;
import com.example.portalback.sys.bean.SysAccountBean;
import com.example.portalback.sys.core.SysManager;
import com.example.portalback.sys.model.AccountModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("sys")
@RestController
public class SysController {

    @Autowired
    private SysManager sysManager;

    @PostMapping("/pageAccount")
    public ResponseObj pageAccount(@RequestBody PageModel model) {
        try {
            Page<SysAccountBean> page = sysManager.pageAccount(model);
            page.map(bean -> {
                bean.setPassword(Constant.PROTECT_PWD);
                return bean;
            });
            return ResponseObj.success(page, "success");
        } catch (Exception e) {
            return ResponseObj.failure(e);
        }
    }

    @GetMapping("getAccountInfo")
    public ResponseObj getAccountInfo() {
        // 登录成功后用户的认证信息 UserDetails会存在 安全上下文寄存器 SecurityContextHolder 中
        SysAccountBean principal =
                (SysAccountBean) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // 脱敏
        principal.setPassword(Constant.PROTECT_PWD);
        return ResponseObj.success(principal, "操作成功");
    }

    /**
     * todo 目前只有用户，没权限
     *
     * @param model
     * @return
     */
    @PostMapping("addAccount")
    public ResponseObj addAccount(@Valid @RequestBody AccountModel model) {
        try {
            sysManager.addAccount(model);
            return ResponseObj.success();
        } catch (Exception e) {
            return ResponseObj.failure(e);
        }
    }

}
