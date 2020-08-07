package com.example.portalback.common.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author LIN
 */
public class DateUtils {

    /**
     * 获取今天 - i天。
     *
     * @param i 可以位负数
     * @return
     */
    public static LocalDateTime getPlusDay(int i) {

        LocalDate localDate = LocalDate.now();
        LocalDate plusDays = localDate.plusDays(-i);
        LocalDateTime localDateTime = plusDays.atStartOfDay();
        return localDateTime;
    }

    /**
     * localdatetime 转 date
     *
     * @param localDateTime
     * @return
     */
    public static Date formatDate(LocalDateTime localDateTime) {

        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        // ZonedDateTime.
        Date date = Date.from(zdt.toInstant());

        return date;
    }

    /**
     * date 转 localdatetime
     *
     * @param date
     * @return
     */
    public static LocalDateTime formatLocalDateTime(Date date) {

        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();

        return localDateTime;
    }

    public static LocalDateTime parseStringToDateTime(String time, String format) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(time, df);
    }
}
