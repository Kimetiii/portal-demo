package com.example.portalback.common.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author songsenior
 * @date 2020/7/30 15:20
 * @Description:
 */
@Component
@Data
@ConfigurationProperties(prefix = "system") // 接收application.yml中的myProps下面的属性
public class AppConfig {
    public String filePath;
    public String urlPath;
}
