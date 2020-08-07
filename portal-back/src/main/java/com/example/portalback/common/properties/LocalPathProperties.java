package com.example.portalback.common.properties;

import com.example.portalback.common.constant.LocalPathConstant;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author LIN
 */
@Setter
@Configuration
@ConfigurationProperties(prefix = "localpath")
public class LocalPathProperties {

    private String template;

    @PostConstruct
    public void init() {
        LocalPathConstant.TEMPLATE = this.template;
    }

}
