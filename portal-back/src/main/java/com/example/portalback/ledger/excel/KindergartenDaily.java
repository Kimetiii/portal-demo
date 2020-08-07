package com.example.portalback.ledger.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.example.portalback.common.config.EasyExcelLocalDateConverter;
import com.example.portalback.ledger.bean.LedgerBean;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Data
public class KindergartenDaily {

    @ExcelProperty("序号")
    private String no;
    @ExcelProperty(value = "记账日期", converter = EasyExcelLocalDateConverter.class)
    private LocalDate recordTime;
    @ExcelProperty("摘要")
    private String content;
    @ExcelProperty("对应科目")
    private String subject;
    @ExcelProperty("贷方金额")
    private String amount;


    public static LedgerBean formatLedgerBean(KindergartenDaily excel) {
        LedgerBean bean = new LedgerBean();
        BeanUtils.copyProperties(excel, bean, "no");
        return bean;
    }


}
