package com.example.portalback.people.core;

import com.example.portalback.people.bean.PeopleBean;
import com.example.portalback.people.service.PeopleService;
import com.example.portalback.people.service.RelationshipService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class PeopleManager {

    @Autowired
    private PeopleService peopleService;

    @Autowired
    private RelationshipService relationshipService;

    public PeopleBean editPeople(PeopleBean bean) {
        Assert.isTrue(StringUtils.isNotBlank(bean.getId()), "peopleId must not null");

        PeopleBean peopleBean = peopleService.editPeople(bean);
        return peopleBean;
    }

    public PeopleBean addPeople(PeopleBean bean) {
        return peopleService.addPeople(bean);
    }

    public void deletePeople(String peopleId) {
        Assert.isTrue(StringUtils.isNotBlank(peopleId), "peopleId must not null");
        peopleService.deletePeople(peopleId);
    }

    public Page<PeopleBean> pagePeople(Integer pageNo, Integer pageSize, String sortKey, String selectKey,
                                       String selectValue) {
        return peopleService.pagePeople(pageNo, pageSize, sortKey, selectKey, selectValue);
    }

}
