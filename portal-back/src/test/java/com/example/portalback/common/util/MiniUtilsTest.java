package com.example.portalback.common.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class MiniUtilsTest {

    @Test
    void code2Session() {

        String code = "033vByy61VoMhO1uJbA61rPxy61vByyd";

        Map<String, Object> map = MiniUtils.code2Session(code);

        System.out.println(map);

    }
}
