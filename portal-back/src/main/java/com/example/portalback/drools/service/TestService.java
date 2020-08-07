package com.example.portalback.drools.service;

import com.example.portalback.drools.dao.ActivityRuleRepository;
import com.example.portalback.drools.domain.ActivityRule;
import com.example.portalback.drools.entity.ActivityRuleEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @AUTHOR lgp
 * @DATE 2018/9/3 15:31
 * @DESCRIPTION
 **/
@Service
public class TestService {


    @Resource
	ActivityRuleRepository activityRuleRepository;

    public List<ActivityRule> selectAll() {
		List<ActivityRuleEntity> activityRules = activityRuleRepository.selectAll();
		List<ActivityRule> list =new ArrayList<>();
		for (ActivityRuleEntity activityRule : activityRules) {
			ActivityRule rule=new ActivityRule();
			BeanUtils.copyProperties(activityRule, rule);
			list.add(rule);
		}
		return list;
    }

    public ActivityRule select1() {
        return activityRuleRepository.selectByPrimaryKey(1);
    }

}
