package com.example.portalback.people.service;

import com.example.portalback.common.util.CustomUtils;
import com.example.portalback.people.bean.PeopleBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.Random;

@SpringBootTest
class PeopleServiceTest {

    @Autowired
    private PeopleService peopleService;

    @Test
    void addPeople() {

        boolean b = true;
        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            PeopleBean bean = new PeopleBean();
            bean.setUsername(CustomUtils.uuid().substring(0, 4));
            bean.setAge(random.nextInt(100));
            bean.setSex(b ? "男" : "女");
            b = !b;
            peopleService.addPeople(bean);
        }
    }

    @Test
    void pagePeople() {

        int pageNo = 0;
        int pageSize = 10;
        String sortKey = "username";
        String selectKey = "ljj";
        String selectValue = "";


        Page<PeopleBean> peopleBeans = peopleService.pagePeople(pageNo, pageSize, sortKey, selectKey, selectValue);

        System.out.println(1);

    }
}
