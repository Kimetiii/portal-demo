package com.example.portalback.drools.service;

import com.example.portalback.people.model.PeopleModel;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author songsenior
 * @date 2020/7/29 11:47
 * @Description:
 */
@Service
public class RuleService {

	@Resource
	private KieBase kieBase;

	public String rule(){
		KieSession kieSession=kieBase.newKieSession();
		PeopleModel peopleModel=new PeopleModel();
		peopleModel.setAge("14");
		kieSession.insert(peopleModel);
		int firedCount = kieSession.fireAllRules();
		kieSession.dispose();
		System.out.println("触发了" + firedCount + "条规则");
		return "触发了" + firedCount + "条规则";
	}
}
