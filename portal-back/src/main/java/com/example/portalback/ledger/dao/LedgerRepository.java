package com.example.portalback.ledger.dao;

import com.example.portalback.ledger.entity.Ledger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author LIN
 */
public interface LedgerRepository extends JpaRepository<Ledger, String>, JpaSpecificationExecutor<Ledger> {

    List<Ledger> findAllByIdIn(List<String> ids);

    boolean existsByContent(String content);

    Integer countByGroupId(String groupId);

    Ledger findByGroupIdAndIdIsNot(String groupId, String id);

}
