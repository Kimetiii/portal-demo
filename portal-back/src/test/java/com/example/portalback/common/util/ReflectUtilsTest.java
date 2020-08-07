package com.example.portalback.common.util;

import com.example.portalback.ledger.entity.Ledger;
import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

public class ReflectUtilsTest {

    @Test
    public void testGetClassFieldStream() {

        List<Field> collect = ReflectUtils.getClassFieldStream(Ledger.class).collect(Collectors.toList());

        System.out.println(1);

    }
}