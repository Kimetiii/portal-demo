package com.example.portalback.common.properties;

import com.example.portalback.common.constant.CloudConstant;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Setter
@Configuration
@ConfigurationProperties(prefix = "cloud")
public class CloudProperties {

    private String secretid;
    private String secretkey;
    private String bucket;

    @PostConstruct
    public void init() {
        CloudConstant.CLOUD_SECRETID = this.secretid;
        CloudConstant.CLOUD_SECRETKEY = this.secretkey;
        CloudConstant.CLOUD_BUCKET = this.bucket;
    }

}
