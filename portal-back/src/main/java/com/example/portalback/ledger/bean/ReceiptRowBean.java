package com.example.portalback.ledger.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@NoArgsConstructor
@Data
public class ReceiptRowBean {

    private String event; //事由或品名

    private String count; //数量

    private String unit; //单位

    private String unitPrice; //单价

    private String money; //金额

    private String s1;//分位
    private String s2;//角位
    private String s3;//元位
    private String s4;//十位
    private String s5;//百位
    private String s6;//千位
    private String s7;//万位
    private String s8;//十万位
    private String s9;//百万位

    public ReceiptRowBean(String event, String count, String unit, String unitPrice, String money) {
        this.event = event;
        this.count = count;
        this.unit = unit;
        this.unitPrice = unitPrice;
        this.money = money;
        this.convert();
    }

    public void convert() {
        Optional.ofNullable(this.money)
                .filter(StringUtils::isNotBlank)
                .map(str -> str.contains(".") ? str : (str + ".00"))
                .ifPresent(money -> {
                    List<String> result = Arrays.stream(money.split("")).filter(str -> StringUtils.equalsAny(str, "0"
                            , "1",
                            "2", "3", "4", "5", "6",
                            "7", "8", "9"))
                            .collect(Collectors.toList());
                    Collections.reverse(result);
                    result.add("￥");
                    IntStream.range(0, result.size()).forEach(index -> {
                        switch (index) {
                            case 0:
                                this.s1 = result.get(index);
                                break;
                            case 1:
                                this.s2 = result.get(index);
                                break;
                            case 2:
                                this.s3 = result.get(index);
                                break;
                            case 3:
                                this.s4 = result.get(index);
                                break;
                            case 4:
                                this.s5 = result.get(index);
                                break;
                            case 5:
                                this.s6 = result.get(index);
                                break;
                            case 6:
                                this.s7 = result.get(index);
                                break;
                            case 7:
                                this.s8 = result.get(index);
                                break;
                            case 8:
                                this.s9 = result.get(index);
                                break;
                            default:
                                throw new ArrayIndexOutOfBoundsException("金额过大");
                        }
                    });
                });
    }

}
