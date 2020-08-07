package com.example.portalback.people.dao;

import com.example.portalback.people.entity.Relationship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RelationshipRepository extends JpaRepository<Relationship, String> {

    List<Relationship> findAllByMasterIdAndServantId(String masterId, String servantId);

    default List<Relationship> findAllByUserId(String userId) {
        return this.findAllByMasterIdAndServantId(userId, userId);
    }

}
