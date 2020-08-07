package com.example.portalback.ledger.core;

import com.example.portalback.common.util.CustomUtils;
import com.example.portalback.common.util.TemplateUtils;
import com.example.portalback.ledger.bean.LedgerBean;
import com.example.portalback.ledger.bean.ReceiptBean;
import com.example.portalback.ledger.model.LedgerModel;
import com.example.portalback.ledger.service.LedgerService;
import com.example.portalback.ledger.util.ExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author LIN
 */
@Slf4j
@Component
public class LedgerManager {

    @Autowired
    private LedgerService ledgerService;

    public Page<LedgerBean> page(LedgerModel model) {
        return ledgerService.page(model);
    }

    public void create4SameGroup(LedgerBean bean) {
        ledgerService.create(bean);
    }

    public void upload(MultipartFile file) throws IOException {
        try (InputStream in = file.getInputStream()) {
            ExcelUtils.importExcel(in);
        }
    }

    public void delete(String id) {
        ledgerService.delete(id);
    }

    public void download(String id, HttpServletResponse response) {
        try {
            ReceiptBean excel = LedgerBean.formatExcel(ledgerService.getOne(id));
            try (InputStream in = TemplateUtils.getTemplate("templates/ledger_template.xlsx");
                 OutputStream out = response.getOutputStream()) {
                response.reset();
                response.addHeader("Access-Control-Allow-Origin", "*");
                response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/x-download");
                response.setHeader("Content-Disposition",
                        "attachment; filename=" + new String("receipt".getBytes(StandardCharsets.UTF_8),
                                "GBK") + ".xlsx");
                ExcelUtils.exportReceipt(out, in, excel);
            }
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
        }
    }

    public void downloadSelect(List<String> ids, HttpServletResponse response) throws IOException {
        List<ReceiptBean> collect =
                ledgerService.findAllByIds(ids).stream().map(LedgerBean::formatExcel).collect(Collectors.toList());

        try (InputStream in = TemplateUtils.getTemplate("templates/ledger_template.xlsx");
             OutputStream out = response.getOutputStream()) {
            response.reset();
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/x-download");
            response.setHeader("Content-Disposition",
                    "attachment; filename=" + new String("receipt".getBytes(StandardCharsets.UTF_8),
                            "GBK") + ".xlsx");
            ExcelUtils.exportReceiptMultipleSheet(out, in, collect);
        }
    }

    public LedgerBean edit(LedgerBean bean) {
        return ledgerService.edit(bean);
    }

    public void deleteSelect(List<String> ids) {
        ledgerService.deleteSelect(ids);
    }

    public void create4SameGroup(List<LedgerBean> collect) {
        String uuid = CustomUtils.uuid();
        LocalDateTime now = LocalDateTime.now();
        collect.forEach(bean -> {
            if (CollectionUtils.size(collect) > 1) {
                bean.setGroupId(uuid);
            }
            bean.setCreateTime(now);
        });
        ledgerService.saveAll(collect);
    }

    public List<LedgerBean> getLedgersByGroupId(String groupId) {
        return ledgerService.getLedgersByGroupId(groupId);
    }

    public void bindingGroupIds(List<String> groupIds) {
        ledgerService.bindingGroupIds(groupIds);
    }

    public void unbindingGroupId(String id) {
        ledgerService.unbindingGroupId(id);
    }
}
