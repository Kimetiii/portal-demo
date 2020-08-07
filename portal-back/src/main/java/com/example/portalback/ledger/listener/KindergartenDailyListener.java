package com.example.portalback.ledger.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.portalback.ledger.bean.LedgerBean;
import com.example.portalback.ledger.excel.KindergartenDaily;
import com.example.portalback.ledger.service.LedgerService;
import com.google.common.base.CharMatcher;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author LIN
 */
@Slf4j
public class KindergartenDailyListener extends AnalysisEventListener<KindergartenDaily> {

    private static final int BATCH_COUNT = 5;
    List<KindergartenDaily> dataList = new ArrayList<>();
    private LedgerService ledgerService;

    public KindergartenDailyListener(LedgerService ledgerService) {
        this.ledgerService = ledgerService;
    }

    @Override
    public void invoke(KindergartenDaily kindergartenDaily, AnalysisContext context) {
        dataList.add(kindergartenDaily);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        this.saveData();
    }

    private void saveData() {
        List<LedgerBean> collect = dataList.stream()
                .map(KindergartenDaily::formatLedgerBean)
                .filter(bean -> StringUtils.isNotBlank(bean.getContent()))
                .peek(bean -> {
                    bean.setCreateTime(LocalDateTime.now());
                    bean.setContent(CharMatcher.whitespace().removeFrom(bean.getContent()));
                    bean.setSubject(CharMatcher.whitespace().removeFrom(bean.getSubject()));
                    bean.setAmount(CharMatcher.whitespace().removeFrom(bean.getAmount()));
                })
                .collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(LedgerBean::getContent))), ArrayList::new));
        log.info("import now. excel count:[{}], save in db count:[{}]", dataList.size(), collect.size());
        ledgerService.saveAllWithoutExist(collect);
    }
}
