package com.example.portalback.people.service.impl;

import com.example.portalback.people.bean.PeopleBean;
import com.example.portalback.people.dao.PeopleRepository;
import com.example.portalback.people.entity.People;
import com.example.portalback.people.service.PeopleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Path;
import java.lang.reflect.Field;
import java.util.Optional;

/**
 * @author LIN
 */
@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    @Override
    public PeopleBean addPeople(PeopleBean bean) {
        People addPeople = PeopleBean.formatPeopleEntity(bean);
        addPeople.setId(null);
        People dbPeople = peopleRepository.saveAndFlush(addPeople);
        return PeopleBean.formatPeopleBean(dbPeople);
    }

    @Override
    public PeopleBean editPeople(PeopleBean bean) {
        People editPeople = PeopleBean.formatPeopleEntity(bean);
        People dbPeople = peopleRepository.saveAndFlush(editPeople);
        return PeopleBean.formatPeopleBean(dbPeople);
    }

    @Override
    public void deletePeople(String peopleId) {
        peopleRepository.deleteById(peopleId);
    }

    @Override
    public Page<PeopleBean> pagePeople(Integer pageNo, Integer pageSize, String sortKey,
                                       String selectKey, String selectValue) {

        String tempSortKey = Optional.ofNullable(sortKey).map(key -> {
            try {
                Field field = People.class.getDeclaredField(key);
                return field.getName();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                return "username";
            }
        }).orElse("username");
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, tempSortKey));

        Specification<People> specification = (Specification<People>) (root, criteriaQuery, criteriaBuilder) -> {
            String key = Optional.ofNullable(selectKey).filter(StringUtils::isNotBlank).orElse("username");
            String value = Optional.ofNullable(selectValue).filter(StringUtils::isNotBlank).orElse("");
            Path<String> username = root.get(key);
            return criteriaBuilder.like(username, "%" + value + "%");
        };

        return peopleRepository.findAll(specification, pageable).map(PeopleBean::formatPeopleBean);
    }

}

