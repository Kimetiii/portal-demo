package com.example.portalback.ledger.model;

import com.example.portalback.base.model.PageModel;
import com.example.portalback.ledger.bean.LedgerBean;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author LIN
 */
@Data
public class LedgerModel extends PageModel {

    private String id;

    private String groupId;

    private String content;

    private String subject;

    private String amount;

    private LocalDate recordTime;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public static LedgerBean formatBean(LedgerModel model) {
        LedgerBean bean = new LedgerBean();
        BeanUtils.copyProperties(model, bean);
        return bean;
    }

}
