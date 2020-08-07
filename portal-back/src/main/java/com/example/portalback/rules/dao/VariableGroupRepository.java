package com.example.portalback.rules.dao;

import com.example.portalback.rules.entity.VariableGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author songsenior
 * @date 2020/8/7 10:58
 * @Description: 规则变量分组dao 编写实现sql
 */
public interface VariableGroupRepository extends JpaRepository<VariableGroup, String>, JpaSpecificationExecutor<VariableGroup> {

}
