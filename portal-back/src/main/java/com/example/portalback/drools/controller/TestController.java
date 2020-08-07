package com.example.portalback.drools.controller;

import com.alibaba.fastjson.JSON;
import com.example.portalback.drools.domain.ActivityRule;
import com.example.portalback.drools.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @AUTHOR lgp
 * @DATE 2018/9/3 14:46
 * @DESCRIPTION 测试接口 mysql h5
 **/
@RestController
@RequestMapping(value = "testNum1")
public class TestController {
    public static final Logger log = LoggerFactory.getLogger(TestController.class);

    @Resource
	TestService testService;

    @RequestMapping("/select1")
    public String select1(Map<String, Object> map) {
        ActivityRule activityRule = testService.select1();
        map.put("hello", JSON.toJSON(activityRule));
        log.info("activityRule={}", JSON.toJSON(activityRule));
        return "/index";
    }

    @RequestMapping("/selectAll")
    public List<ActivityRule> selectAll() {
        List<ActivityRule> list = testService.selectAll();
        return list;
    }

    @RequestMapping("/index")
    public String index(Map<String, Object> map) {
        log.info("index");
        map.put("hello", "from HiController map");
        return "/index";
    }
}
