package com.example.portalback.people.dao;

import com.example.portalback.people.entity.People;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.List;

@SpringBootTest
class ActivityRuleRepositoryTest {

    @Autowired
    private PeopleRepository peopleRepository;

    @Test
    void name() {

        Integer pageNo = 0;
        Integer pageSize = 10;

        PageRequest request = PageRequest.of(pageNo, pageSize);


        Specification<People> specification = (root, cq, cb) -> {
            Path<String> username = root.get("username");
            Predicate equal = cb.equal(username, "linjunjie");

            return equal;
        };


        Page<People> all = peopleRepository.findAll(specification, request);

        List<People> people = peopleRepository.findAll(specification);

        PageImpl page = new PageImpl(people, request, people.size());

        System.out.println(1);

    }
}