package com.example.portalback.ledger.bean;

import com.example.portalback.ledger.entity.Ledger;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.stream.IntStream;

/**
 * @author LIN
 */
@Data
public class LedgerBean {

    private String id;

    private String groupId;

    private String content;

    private String subject;

    private String amount;

    private LocalDate recordTime;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public static LedgerBean formatBean(Ledger ledger) {
        LedgerBean bean = new LedgerBean();
        BeanUtils.copyProperties(ledger, bean);
        return bean;
    }

    public static ReceiptBean formatExcel(LedgerBean bean) {
        ReceiptRowBean rowBean = new ReceiptRowBean(bean.getContent(), null, null, null, bean.getAmount());
        ReceiptBean excel = new ReceiptBean(bean.getAmount(), bean.getRecordTime(), bean.getSubject(),
                Collections.singletonList(rowBean));
        return excel;
    }

    public static Ledger getEntity(LedgerBean bean) {
        Ledger entity = new Ledger();
        int pointCount = StringUtils.substringAfter(bean.getAmount(), ".").length();
        if (pointCount < 2) {
            StringBuilder sb = new StringBuilder(bean.getAmount() + ".");
            IntStream.range(0, 2 - pointCount).forEach(index -> sb.append("0"));
            bean.setAmount(sb.toString());
        } else if (pointCount > 2) {
            String prefix = StringUtils.substringBefore(bean.getAmount(), ".");
            String suffix = StringUtils.substringAfter(bean.getAmount(), ".");
            bean.setAmount(prefix + "." + suffix.substring(0, 2));
        }
        BeanUtils.copyProperties(bean, entity);
        return entity;
    }

}
