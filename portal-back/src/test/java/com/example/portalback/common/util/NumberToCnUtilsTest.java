package com.example.portalback.common.util;

import com.example.portalback.ledger.enums.NumberToCnEnums;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class NumberToCnUtilsTest {

    @Test
    public void testTransform() {

        Optional.ofNullable("123.54").filter(StringUtils::isNotBlank).ifPresent(money -> {
            List<String> result = Arrays.stream(money.split("")).filter(str -> StringUtils.equalsAny(str, "0", "1",
                    "2", "3", "4", "5", "6",
                    "7", "8", "9"))
                    .map(NumberToCnEnums::getCnByAr)
                    .collect(Collectors.toList());
            Collections.reverse(result);
            System.out.println(1);
        });

    }


}
