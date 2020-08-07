package com.example.portalback.common.util;

import com.example.portalback.common.constant.MiniConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.IOException;
import java.util.Map;

@Slf4j
public class MiniUtils {

    public static Map<String, Object> code2Session(String code) {
        String urlStr = new StringBuffer()
                .append(MiniConstant.CODE_SESSION).append("?")
                .append("appid=").append(MiniConstant.APPID)
                .append("&secret=").append(MiniConstant.APPSECRET)
                .append("&js_code=").append(code)
                .append("&grant_type=").append("authorization_code")
                .toString();

        try {
            log.info("url:[{}]", urlStr);
            return HttpUtils.sendGet4Map(urlStr);
        } catch (IOException e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return null;
        }
    }

}
