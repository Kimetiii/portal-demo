package com.example.portalback.ledger.util;

import com.example.portalback.ledger.bean.ReceiptBean;
import com.example.portalback.ledger.bean.ReceiptRowBean;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ExcelUtilsTest {

    private static String filePath;

    private static String templatePath;

    @BeforeClass
    public void beforeClass() {
//        filePath = "/Users/lin/Documents/workspace/Daily/doc/template/test.xlsx";
//        templatePath = "/Users/lin/Documents/workspace/Daily/doc/template/template1.xlsx";
        filePath = "C:\\Users\\A\\Desktop\\easyexcel\\result.xlsx";
        templatePath = "C:\\Users\\A\\Desktop\\easyexcel\\ledger_template.xlsx";

    }

    @Test
    public void testExport() {

        ReceiptRowBean entity = new ReceiptRowBean();
        entity.setEvent("测试");
        entity.setMoney("100");
        entity.convert();

        ReceiptRowBean entity2 = new ReceiptRowBean();
        entity2.setEvent("测试2");
        entity2.setMoney("100.00");
        entity2.convert();

        List<ReceiptRowBean> receiptRowBeans = Arrays.asList(entity, entity2);

        ReceiptBean bean = new ReceiptBean();
        bean.setAmount("100");
        bean.convert();
        bean.setReceiptRowBeans(receiptRowBeans);

    }

}
