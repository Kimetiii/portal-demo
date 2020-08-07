package com.example.portalback.ledger.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Optional;


/**
 * @author LIN
 */

@Getter
public enum SubjectTypeEnums {

    WELFARE("welfare", "福利"),
    LOGISTICS("logistics", "后勤"),
    WAGE("wage", "工资"),
    OTHER("other", "其他"),
    COMMUNICATION("communication", "通讯"),
    HOUSING("housing", "住房");

    private String enName;

    private String cnName;

    SubjectTypeEnums(String enName, String cnName) {
        this.enName = enName;
        this.cnName = cnName;
    }

    public static String getEnByCn(String cnName) {
        return Optional.ofNullable(cnName)
                .flatMap(name -> Arrays.stream(SubjectTypeEnums.values()).filter(enums -> StringUtils.equals(enums.cnName,
                        name)).findFirst())
                .map(SubjectTypeEnums::getEnName)
                .orElse(null);
    }

}
