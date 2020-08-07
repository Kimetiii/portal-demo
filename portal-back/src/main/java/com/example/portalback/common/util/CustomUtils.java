package com.example.portalback.common.util;

import java.util.UUID;

public class CustomUtils {

    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
