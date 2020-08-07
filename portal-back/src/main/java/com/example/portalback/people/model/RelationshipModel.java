package com.example.portalback.people.model;

import com.example.portalback.people.bean.RelationshipBean;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
public class RelationshipModel {

    private String id;
    private String name;
    private String masterId;
    private String servantId;
    private LocalDateTime addTime;
    private String remark;

    public static RelationshipBean formatBean(RelationshipModel model) {
        RelationshipBean relationship = new RelationshipBean();
        BeanUtils.copyProperties(model, relationship);
        return relationship;
    }

}
