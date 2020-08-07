package com.example.portalback.tool.core;

import com.example.portalback.common.util.CosUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Component
public class ToolManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(ToolManager.class);

    public String uploadFile(MultipartFile file) throws IOException {
        try (InputStream in = file.getInputStream()) {
            String url = CosUtils.saveAvatar(in, file.getOriginalFilename());
            return url;
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            throw new IOException("uploadFile error");
        }
    }
}
