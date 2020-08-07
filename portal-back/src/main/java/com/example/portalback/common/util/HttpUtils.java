package com.example.portalback.common.util;

import com.alibaba.fastjson.JSON;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class HttpUtils {

    public static Map<String, Object> sendGet4Map(String urlStr) throws IOException {
        try (InputStream in = connect4Get(urlStr);) {
            String result = StreamUtils.copyToString(in, StandardCharsets.UTF_8);
            return JSON.parseObject(result, Map.class);
        }
    }

    public static Map<String, Object> sendPost4Map(String urlStr, Map<String, ?> map) throws IOException {

        try (InputStream in = connect4Post(urlStr, map)) {
            String result = StreamUtils.copyToString(in, StandardCharsets.UTF_8);
            return JSON.parseObject(result, Map.class);
        }
    }

    private static InputStream connect4Get(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        URLConnection conn = url.openConnection();
        conn.setRequestProperty("content-type", "application/x-www-form-urlencoded;charset=utf-8");
        conn.setRequestProperty("method", "GET");
        conn.connect();
        return conn.getInputStream();
    }

    private static InputStream connect4Post(String urlStr, Map<String, ?> map) throws IOException {
        String data = JSON.toJSONString(map);
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");// 提交模式
        // conn.setConnectTimeout(10000);//连接超时 单位毫秒
        // conn.setReadTimeout(2000);//读取超时 单位毫秒
        // 发送POST请求必须设置如下两行
        conn.setDoOutput(true);
        conn.setDoInput(true);
        // 获取URLConnection对象对应的输出流
        PrintWriter writer = new PrintWriter(conn.getOutputStream());
        // 发送请求参数
        writer.write(data);
        // flush输出流的缓冲
        writer.flush();
        //开始获取数据
        InputStream in = conn.getInputStream();
        writer.close();
        return in;
    }


}