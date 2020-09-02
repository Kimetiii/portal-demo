package com.example.portalback.people.service.impl;

import com.example.portalback.people.bean.RelationshipBean;
import com.example.portalback.people.dao.RelationshipInfoRepository;
import com.example.portalback.people.dao.RelationshipRepository;
import com.example.portalback.people.entity.Relationship;
import com.example.portalback.people.entity.RelationshipInfo;
import com.example.portalback.people.service.RelationshipService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RelationshipServiceImpl implements RelationshipService {

    @Resource
    private RelationshipRepository relationshipRepository;

    @Resource
    private RelationshipInfoRepository relationshipInfoRepository;


    @Override
    public List<RelationshipBean> editRelationshipInfo(String userId, List<RelationshipBean> relationshipBeans) {

        List<RelationshipInfo> saveInfos =
                relationshipBeans.stream().map(RelationshipBean::getEntity).collect(Collectors.toList());

        List<RelationshipInfo> dbInfos = relationshipInfoRepository.saveAll(saveInfos);

        List<Relationship> dbRelationships = relationshipRepository.findAllByUserId(userId);


        return null;
    }
}
