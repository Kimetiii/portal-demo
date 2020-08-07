package com.example.portalback.common.util;

import com.example.portalback.common.constant.CloudConstant;
import com.example.portalback.common.constant.Constant;
import com.example.portalback.common.core.CosCore;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class CosUtils {

    private static final String IMAGE_DIR = "image";

    public static String saveAvatar(Path filePath) throws IOException {

        return CosUtils.saveAvatar(Files.newInputStream(filePath), filePath.getFileName().toString());
    }

    public static String saveAvatar(InputStream in, String fileName) {

        ObjectMetadata objectMetadata = new ObjectMetadata();

        String avatarName = CustomUtils.uuid() + "_" + fileName;

        String key = IMAGE_DIR + "/" + avatarName;

        PutObjectRequest putObjectRequest = new PutObjectRequest(CloudConstant.CLOUD_BUCKET, key, in, objectMetadata);

        try (CosCore core = new CosCore()) {
            core.saveFile(putObjectRequest);
        }

        return Constant.COS_URL + "/" + key;
    }

}
