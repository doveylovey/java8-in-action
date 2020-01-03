package com.study.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * JDK8 中新的日期时间 API 测试类2
 *
 * @author administrator
 */
public class NewDateTest2 {
    public static void main(String[] args) {
        test01();
    }

    private static void test01() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 当前日期
        LocalDate now = LocalDate.now();
        // 昨天
        LocalDate yesterday = now.minusDays(1);
        // 明天
        LocalDate tomorrow = now.plusDays(1);

        // 昨天开始时间
        LocalDateTime yesterday_start = LocalDateTime.of(yesterday, LocalTime.MIN);
        System.out.println("昨天开始时间：" + yesterday_start.format(dateTimeFormatter));
        // 昨天结束时间
        LocalDateTime yesterday_end = LocalDateTime.of(yesterday, LocalTime.MAX);
        System.out.println("昨天结束时间：" + yesterday_end.format(dateTimeFormatter));

        // 今天开始时间
        LocalDateTime today_start = LocalDateTime.of(now, LocalTime.MIN);
        System.out.println("今天开始时间：" + today_start.format(dateTimeFormatter));
        // 今天结束时间
        LocalDateTime today_end = LocalDateTime.of(now, LocalTime.MAX);
        System.out.println("今天结束时间：" + today_end.format(dateTimeFormatter));

        // 明天开始时间
        LocalDateTime tomorrow_start = LocalDateTime.of(tomorrow, LocalTime.MIN);
        System.out.println("明天开始时间：" + tomorrow_start.format(dateTimeFormatter));
        // 明天结束时间
        LocalDateTime tomorrow_end = LocalDateTime.of(tomorrow, LocalTime.MAX);
        System.out.println("明天结束时间：" + tomorrow_end.format(dateTimeFormatter));
    }
}
