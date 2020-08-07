package com.example.portalback.common.core;

import com.example.portalback.common.constant.CloudConstant;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.Optional;

@Slf4j
public class CosCore implements AutoCloseable {

    private COSCredentials credentials;

    private ClientConfig clientConfig;

    private COSClient cosClient;

    public CosCore() {
        credentials = new BasicCOSCredentials(CloudConstant.CLOUD_SECRETID, CloudConstant.CLOUD_SECRETKEY);
        Region region = new Region("ap-guangzhou");
        clientConfig = new ClientConfig(region);
        cosClient = new COSClient(credentials, clientConfig);
    }

    public boolean saveFile(PutObjectRequest request) {
        try {
            PutObjectResult result = cosClient.putObject(request);
            return true;
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return false;
        }
    }

    @Override
    public void close() {
        Optional.ofNullable(cosClient).ifPresent(COSClient::shutdown);
    }
}
