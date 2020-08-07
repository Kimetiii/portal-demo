package com.example.portalback.common.util;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Stream;

public class ReflectUtils {

    public static Stream<Field> getClassFieldStream(Class<?> clazz) {
        return Arrays.stream(clazz.getDeclaredFields());
    }

}
