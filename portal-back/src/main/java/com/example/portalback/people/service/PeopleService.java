package com.example.portalback.people.service;

import com.example.portalback.people.bean.PeopleBean;
import org.springframework.data.domain.Page;

/**
 * @author LIN
 */
public interface PeopleService {

    PeopleBean addPeople(PeopleBean bean);

    PeopleBean editPeople(PeopleBean bean);

    void deletePeople(String peopleId);

    Page<PeopleBean> pagePeople(Integer pageNo, Integer pageSize, String sortKey, String selectKey,String selectValue);
}
