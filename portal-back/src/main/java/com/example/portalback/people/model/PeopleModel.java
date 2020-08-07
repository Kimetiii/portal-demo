package com.example.portalback.people.model;

import com.example.portalback.people.bean.PeopleBean;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class PeopleModel {

    private String id; //peopleId
    private String username;
    private String age;
    private String sex;
    private String avatar;

    public static PeopleBean formatBean(PeopleModel model) {
        PeopleBean bean = new PeopleBean();
        BeanUtils.copyProperties(model, bean);
        return bean;
    }

}
