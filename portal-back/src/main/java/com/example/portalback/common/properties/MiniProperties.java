package com.example.portalback.common.properties;

import com.example.portalback.common.constant.MiniConstant;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Setter
@Configuration
@ConfigurationProperties(prefix = "mini")
public class MiniProperties {

    private String appid;
    private String appsecret;
    private String code2Session;

    @PostConstruct
    public void init() {
        MiniConstant.APPID = this.appid;
        MiniConstant.APPSECRET = this.appsecret;
        MiniConstant.CODE_SESSION = this.code2Session;
    }

}
