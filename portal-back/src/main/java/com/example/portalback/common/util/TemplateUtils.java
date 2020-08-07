package com.example.portalback.common.util;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

public class TemplateUtils {

    public static InputStream getTemplate(String relationPath) throws IOException {
        ClassPathResource resource = new ClassPathResource(relationPath);
        return resource.getInputStream();
    }

}
