package com.example.portalback.people.bean;

import com.example.portalback.common.constant.Constant;
import com.example.portalback.people.entity.People;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

@Data
public class PeopleBean {

    private String id;
    private String sex;
    private String username;
    private Integer age;
    private String avatar;

    public static People formatPeopleEntity(PeopleBean bean) {
        People entity = new People();
        BeanUtils.copyProperties(bean, entity);
        return entity;
    }

    public static PeopleBean formatPeopleBean(People people) {
        PeopleBean bean = new PeopleBean();
        BeanUtils.copyProperties(people, bean);
        if (StringUtils.isBlank(bean.getAvatar())) {
            bean.setAvatar(Constant.DEFAULT_AVATAR);
        }
        return bean;
    }
}
