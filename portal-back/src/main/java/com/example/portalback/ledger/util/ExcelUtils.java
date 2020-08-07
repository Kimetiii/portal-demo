package com.example.portalback.ledger.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.example.portalback.common.constant.LocalPathConstant;
import com.example.portalback.common.util.SpringUtils;
import com.example.portalback.ledger.bean.ReceiptBean;
import com.example.portalback.ledger.bean.ReceiptRowBean;
import com.example.portalback.ledger.excel.KindergartenDaily;
import com.example.portalback.ledger.listener.KindergartenDailyListener;
import com.example.portalback.ledger.service.LedgerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author LIN
 */
@Slf4j
public class ExcelUtils {

    public static void exportReceipt(OutputStream out, InputStream in, ReceiptBean data) {
        ExcelWriter excelWriter = EasyExcel.write(out).withTemplate(in).build();
        WriteSheet writeSheet = EasyExcel.writerSheet().build();

        List<ReceiptRowBean> receiptRowBeans =
                Optional.ofNullable(data.getReceiptRowBeans()).orElse(Collections.emptyList()).stream().limit(3).collect(Collectors.toList());

        excelWriter.fill(receiptRowBeans, writeSheet);
        excelWriter.fill(data, writeSheet);
        excelWriter.finish();
    }

    public static void exportReceiptMultipleSheet(OutputStream out, InputStream in, List<ReceiptBean> datas) throws IOException {
        Path templatePath = Paths.get(LocalPathConstant.TEMPLATE,
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmSS")) + ".xlsx");
        ExcelUtils.cloneSheet(in, templatePath.toString(), datas.size() - 1);

        ExcelWriter excelWriter = EasyExcel.write(out).withTemplate(templatePath.toFile()).build();

        IntStream.range(0, datas.size()).forEach(index -> {
            ReceiptBean receiptBean = datas.get(index);
            List<ReceiptRowBean> receiptRowBeans =
                    Optional.ofNullable(receiptBean.getReceiptRowBeans()).orElse(Collections.emptyList()).stream().limit(3).collect(Collectors.toList());
            WriteSheet writeSheet = EasyExcel.writerSheet(index).build();
            excelWriter.fill(receiptRowBeans, writeSheet);
            excelWriter.fill(receiptBean, writeSheet);
        });
        excelWriter.finish();
    }

    public static void importExcel(InputStream in) {
        ExcelReader excelReader = null;
        try {
            excelReader = EasyExcel.read(in, KindergartenDaily.class,
                    new KindergartenDailyListener(SpringUtils.getBean(LedgerService.class))).build();
            ReadSheet readSheet = EasyExcel.readSheet(0).build();
            excelReader.read(readSheet);
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
        } finally {
            if (excelReader != null) {
                excelReader.finish();
            }
        }

    }

    private static void cloneSheet(InputStream in, String filePath, Integer count) throws IOException {
        try (Workbook wb = new XSSFWorkbook(in);
             FileOutputStream out = new FileOutputStream(filePath)) {
            IntStream.range(0, count).forEach(i -> wb.cloneSheet(0));
            out.flush();
            wb.write(out);
        }
    }

}
