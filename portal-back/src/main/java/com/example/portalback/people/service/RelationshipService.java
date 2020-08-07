package com.example.portalback.people.service;

import com.example.portalback.people.bean.RelationshipBean;

import java.util.List;

public interface RelationshipService {

    List<RelationshipBean> editRelationshipInfo(String userId, List<RelationshipBean> relationships);
}
