package com.example.portalback.rules.dao;

import com.example.portalback.rules.entity.Variable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author songsenior
 * @date 2020/8/7 10:58
 * @Description: 规则变量dao 编写实现sql
 */
public interface VariableRepository extends JpaRepository<Variable, String>, JpaSpecificationExecutor<Variable> {

}
