package com.example.portalback.people.dao;

import com.example.portalback.people.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PeopleRepository extends JpaRepository<People, String>, JpaSpecificationExecutor<People> {
}
