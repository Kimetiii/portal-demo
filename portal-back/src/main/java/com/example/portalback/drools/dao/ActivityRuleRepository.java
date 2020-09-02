package com.example.portalback.drools.dao;

import com.example.portalback.drools.entity.ActivityRuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActivityRuleRepository extends JpaRepository<ActivityRuleEntity, String> {

	/**
	 * 查询所有规则
	 *
	 * @return 规则信息集合
	 */
	@Query(value = "select\n" +
			"        id, task_id, event, rule_value, priority, awardee_type, send_award_times, create_by,\n" +
			"        create_time, update_by, update_time, is_delete, is_sms_notice\n" +
			"        from activity_rule WHERE is_delete=0", nativeQuery = true)
	List<ActivityRuleEntity> selectAll();

	/**
	 * 根据主键查询单条规则
	 *
	 * @param id 主键
	 * @return 规则bean
	 */
	@Query(value = "select \n" +
			"      id, task_id, event, rule_value, priority, awardee_type, send_award_times, create_by,\n" +
			"      create_time, update_by, update_time, is_delete, is_sms_notice\n" +
			"    from activity_rule\n" +
			"    where id =?1", nativeQuery = true)
	ActivityRuleEntity selectByPrimaryKey(Integer id);

}
