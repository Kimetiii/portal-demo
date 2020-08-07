package com.example.portalback.people.bean;

import com.example.portalback.people.entity.RelationshipInfo;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
public class RelationshipBean {

    private String id;
    private String name;
    private String masterId;
    private String servantId;
    private LocalDateTime addTime;
    private String remark;

    public static RelationshipInfo getEntity(RelationshipBean bean) {

        RelationshipInfo entity = new RelationshipInfo();
        BeanUtils.copyProperties(bean, entity);

        return entity;
    }
}
