package com.example.portalback.ledger.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import java.util.Arrays;

/**
 * @author LIN
 */

@Getter
public enum NumberToCnEnums {

    ZERO("零", "0"),
    ONE("壹", "1"),
    TWO("贰", "2"),
    THREE("叁", "3"),
    FOUR("肆", "4"),
    FIVE("伍", "5"),
    SIX("陆", "6"),
    SEVEN("柒", "7"),
    EIGHT("捌", "8"),
    NIGHT("玖", "9");

    private String cnName;//中文大写数字
    private String arName;//阿拉伯数字

    NumberToCnEnums(String cnName, String arName) {
        this.cnName = cnName;
        this.arName = arName;
    }

    /**
     * 通过阿拉伯数字找到大写
     *
     * @param arabicName 阿拉伯数字
     * @return 中文大写
     */
    public static String getCnByAr(String arabicName) {
        Assert.isTrue(StringUtils.isNotBlank(arabicName), "must not null");
        Assert.isTrue(StringUtils.equalsAny(arabicName, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"), "must be " +
                "number");

        return Arrays.stream(NumberToCnEnums.values()).filter(enums -> enums.arName.equals(arabicName)).findFirst().get().getCnName();
    }

}
