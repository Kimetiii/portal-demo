package com.example.portalback.ledger.bean;

import com.example.portalback.ledger.enums.NumberToCnEnums;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@NoArgsConstructor
@Data
public class ReceiptBean {

    private String amount; //总计金额

    private LocalDate recordTime; //记录时间

    private String subject; //科目

    private List<ReceiptRowBean> receiptRowBeans; //行 size最多为3

    private String year;//年
    private String month;//月
    private String day;//日

    private String m1;//分位
    private String m2;//角位
    private String m3;//元位
    private String m4;//十位
    private String m5;//百位
    private String m6;//千位
    private String m7;//万位
    private String m8;//十万位
    private String m9;//百万位

    public ReceiptBean(String amount, LocalDate recordTime, String subject, List<ReceiptRowBean> receiptRowBeans) {
        this.amount = amount;
        this.recordTime = recordTime;
        this.subject = subject;
        this.receiptRowBeans = receiptRowBeans;
        this.convert();
    }

    public void convert() {
        Optional.ofNullable(this.amount)
                .filter(StringUtils::isNotBlank)
                .map(str -> str.contains(".") ? str : (str + ".00"))
                .ifPresent(money -> {
                    List<String> result = Arrays.stream(money.split("")).filter(str -> StringUtils.equalsAny(str, "0"
                            , "1",
                            "2", "3", "4", "5", "6",
                            "7", "8", "9"))
                            .map(NumberToCnEnums::getCnByAr)
                            .collect(Collectors.toList());
                    Collections.reverse(result);
                    result.add("￥");
                    IntStream.range(0, result.size()).forEach(index -> {
                        switch (index) {
                            case 0:
                                this.m1 = result.get(index);
                                break;
                            case 1:
                                this.m2 = result.get(index);
                                break;
                            case 2:
                                this.m3 = result.get(index);
                                break;
                            case 3:
                                this.m4 = result.get(index);
                                break;
                            case 4:
                                this.m5 = result.get(index);
                                break;
                            case 5:
                                this.m6 = result.get(index);
                                break;
                            case 6:
                                this.m7 = result.get(index);
                                break;
                            case 7:
                                this.m8 = result.get(index);
                                break;
                            case 8:
                                this.m9 = result.get(index);
                                break;
                            default:
                                throw new ArrayIndexOutOfBoundsException("金额过大");
                        }
                    });
                });
        Optional.ofNullable(this.recordTime).ifPresent(time -> {
            this.year = String.valueOf(time.getYear()).substring(2);
            this.month = String.valueOf(time.getMonth().getValue());
            this.day = String.valueOf(time.getDayOfMonth());
        });

    }

}
