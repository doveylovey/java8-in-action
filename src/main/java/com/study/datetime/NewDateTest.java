package com.study.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * JDK8 中新的日期时间 API 测试类
 *
 * @author administrator
 */
public class NewDateTest {
    public static void main(String[] args) {
        test01();
        test02();
        test03();
        test04();
        test05();
        test06();
        test07();
        test08();
    }

    private static void test01() {
        // 当前日期
        LocalDate now = LocalDate.now();
        // 指定日期
        //now = LocalDate.of(2019, 2, 10);
        System.out.println("\n========== 当前日期相关 ==========");
        System.out.println("年月日：" + now);
        System.out.println("年：" + now.getYear());
        System.out.println("本年共" + now.lengthOfYear() + "天");
        System.out.println("月(从1开始)：" + now.getMonthValue());
        System.out.println("日(从1开始)：" + now.getDayOfMonth());
        System.out.println("本月共" + now.lengthOfMonth() + "天");
        System.out.println("星期：" + now.getDayOfWeek().getValue());
        System.out.println("与时间纪元(1970-01-01)相差的天数，负数表示在时间纪元之前：" + now.toEpochDay());
        // 设置本月第一天
        LocalDate firstDay = LocalDate.of(now.getYear(), now.getMonth(), 1);
        //firstDay = now.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("本月第一天：" + firstDay.getDayOfMonth());
        // 设置本月最后一天
        LocalDate lastDay = now.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("本月最后一天：" + lastDay.getDayOfMonth());
    }

    private static void test02() {
        // 当前日期
        LocalDate now = LocalDate.now();
        // 指定日期
        //now = LocalDate.of(2019, 2, 10);
        System.out.println("\n========== 日期加减法 ==========");
        System.out.println("年月日：" + now);
        System.out.println("加1天：" + now.plusDays(1));
        System.out.println("减1天：" + now.plusDays(-1));
        System.out.println("加1天：" + now.minusDays(-1));
        System.out.println("减1天：" + now.minusDays(1));

        System.out.println("加1周：" + now.plusWeeks(1));
        System.out.println("减1周：" + now.plusWeeks(-1));
        System.out.println("加1周：" + now.minusWeeks(-1));
        System.out.println("减1周：" + now.minusWeeks(1));

        System.out.println("加1月：" + now.plusMonths(1));
        System.out.println("减1月：" + now.plusMonths(-1));
        System.out.println("加1月：" + now.minusMonths(-1));
        System.out.println("减1月：" + now.minusMonths(1));

        System.out.println("加1年：" + now.plusYears(1));
        System.out.println("减1年：" + now.plusYears(-1));
        System.out.println("加1年：" + now.minusYears(-1));
        System.out.println("减1年：" + now.minusYears(1));
    }

    private static void test03() {
        // 当前日期
        LocalDate now = LocalDate.now();
        // 指定日期
        //now = LocalDate.of(2019, 2, 10);
        System.out.println("\n========== 日期字段替换：所有的数值必须合法，如果当月当天是闰年2月29日，替换年份为非闰年，则会变成2月28日 ==========");
        System.out.println("年月日：" + now);
        System.out.println("替换日期为1：" + now.withDayOfMonth(1));
        System.out.println("替换天数为1：" + now.withDayOfYear(1));
        System.out.println("替换月份为1：" + now.withMonth(1));
        System.out.println("替换年份为2008：" + now.withYear(2008));
        System.out.println("替换日期为本月第一天：" + now.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println("替换日期为本月最后一天：" + now.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println("替换日期为本月第一天：" + now.with(ChronoField.DAY_OF_MONTH, 1));
    }

    private static void test04() {
        // 指定日期
        LocalDate before = LocalDate.of(2008, 8, 8);
        // 当前日期
        LocalDate now = LocalDate.now();
        System.out.println("\n========== 日期判断 ==========");
        System.out.println("before：" + before);
        System.out.println("now：" + now);
        System.out.println("now是否在now之前：" + now.isBefore(now));
        System.out.println("now是否在now之后：" + now.isAfter(now));
        System.out.println("before是否在now之前：" + before.isBefore(now));
        System.out.println("before是否在now之后：" + before.isAfter(now));
        System.out.println("now是否在before之前：" + now.isBefore(before));
        System.out.println("now是否在before之后：" + now.isAfter(before));
        System.out.println("now.compareTo(before)：" + now.compareTo(before));
        System.out.println("是否当天：" + now.isEqual(now));
        System.out.println("今年是否闰年：" + now.isLeapYear());
    }

    private static void test05() {
        // 当前日期
        LocalDate now1 = LocalDate.now();
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println("\n========== 日期格式化 ==========");
        System.out.println("now1：" + now1);
        System.out.println("now2：" + now2);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("日期格式化：" + now1.format(dateFormatter));
        System.out.println("时间格式化：" + now2.format(timeFormatter));
        System.out.println("日期时间格式化：" + now2.format(dateTimeFormatter));
    }

    private static void test06() {
        System.out.println("\n========== Duration测试类 ==========");
        System.out.println("==========>使用Instant(默认是当前美国时间，和我们相差8小时)");
        Instant inst1 = Instant.now();
        System.out.println("Inst1: " + inst1);
        Instant inst2 = inst1.plus(Duration.ofSeconds(10));
        System.out.println("Inst2: " + inst2);
        Duration between1 = Duration.between(inst1, inst2);
        System.out.printf("Inst1和Inst2相差: %d毫秒\n", between1.toMillis());
        System.out.printf("Inst1和Inst2相差: %d秒\n\n", between1.getSeconds());

        System.out.println("==========>使用LocalDateTime(当地时间)");
        LocalDateTime time1 = LocalDateTime.now();
        System.out.println("time1: " + time1);
        LocalDateTime time2 = time1.plus(Duration.ofSeconds(10));
        System.out.println("time2: " + time2);
        Duration between2 = Duration.between(time1, time2);
        System.out.printf("time1和time2相差: %d毫秒\n", between2.toMillis());
        System.out.printf("time1和time2相差: %d秒\n\n", between2.getSeconds());

        System.out.println("==========>使用ZonedDateTime(使用ZoneId.systemDefault()获取本地的默认时区ID)");
        // atZone()方法的参数是要一个时区的编号可以通过时区编号类ZoneId获取出来。ZoneId世界时区编号的一个类
        ZonedDateTime zonedDateTime1 = Instant.now().atZone(ZoneId.systemDefault());
        System.out.println("zonedDateTime1: " + zonedDateTime1);
        ZonedDateTime zonedDateTime2 = zonedDateTime1.plus(Duration.ofSeconds(10));
        System.out.println("zonedDateTime2: " + zonedDateTime2);
        Duration between3 = Duration.between(zonedDateTime1, zonedDateTime2);
        System.out.printf("zonedDateTime1和zonedDateTime2相差: %d毫秒\n", between3.toMillis());
        System.out.printf("zonedDateTime1和zonedDateTime2相差: %d秒\n\n", between3.getSeconds());

        System.out.println("==========>使用ZonedDateTime(获取任意时区的时间)");
        ZonedDateTime zonedDateTime3 = Instant.now().atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println("zonedDateTime3: " + zonedDateTime3);
        ZonedDateTime zonedDateTime4 = zonedDateTime3.plus(Duration.ofSeconds(10));
        System.out.println("zonedDateTime4: " + zonedDateTime4);
        Duration between4 = Duration.between(zonedDateTime3, zonedDateTime4);
        System.out.printf("offsetDateTime1和offsetDateTime2相差: %d毫秒\n", between4.toMillis());
        System.out.printf("offsetDateTime1和offsetDateTime2相差: %d秒\n\n", between4.getSeconds());

        System.out.println("==========>使用OffsetDateTime(ZoneOffset设置偏移时间)");
        OffsetDateTime offsetDateTime1 = Instant.now().atOffset(ZoneOffset.ofHours(8));
        System.out.println("offsetDateTime1: " + offsetDateTime1);
        OffsetDateTime offsetDateTime2 = offsetDateTime1.plus(Duration.ofSeconds(10));
        System.out.println("offsetDateTime2: " + offsetDateTime2);
        Duration between5 = Duration.between(offsetDateTime1, offsetDateTime2);
        System.out.printf("offsetDateTime1和offsetDateTime2相差: %d毫秒\n", between5.toMillis());
        System.out.printf("offsetDateTime1和offsetDateTime2相差: %d秒\n", between5.getSeconds());
    }

    private static void test07() {
        System.out.println("\n========== Period + LocalDate测试类 ==========");
        LocalDate birthday = LocalDate.of(2018, 12, 10);
        System.out.println("day1: " + birthday);
        LocalDate now = LocalDate.now();
        System.out.println("day2: " + now);
        Period between1 = Period.between(birthday, now);
        System.out.printf("day1和day2相隔: %d年%d个月%d天\n", between1.getYears(), between1.getMonths(), between1.getDays());
        long betweenYear = ChronoUnit.YEARS.between(birthday, now);
        System.out.printf("day1和day2相隔: %d年\n", betweenYear);
        long betweenMonth = ChronoUnit.MONTHS.between(birthday, now);
        System.out.printf("day1和day2相隔: %d个月\n", betweenMonth);
        long betweenDay = ChronoUnit.DAYS.between(birthday, now);
        System.out.printf("day1和day2相隔: %d天\n", betweenDay);
    }

    private static void test08() {
        System.out.println("\n========== Period + LocalDate测试类 ==========");
        LocalDateTime birthday = LocalDateTime.of(2018, 12, 10, 0, 0, 0);
        System.out.println("time1: " + birthday);
        LocalDateTime now = LocalDateTime.now();
        System.out.println("time2: " + now);
        long betweenYear = ChronoUnit.YEARS.between(birthday, now);
        System.out.printf("time1和time2相隔: %d年\n", betweenYear);
        long betweenMonth = ChronoUnit.MONTHS.between(birthday, now);
        System.out.printf("time1和time2相隔: %d个月\n", betweenMonth);
        long betweenDay = ChronoUnit.DAYS.between(birthday, now);
        System.out.printf("time1和time2相隔: %d天\n", betweenDay);
        long betweenHour = ChronoUnit.HOURS.between(birthday, now);
        System.out.printf("time1和time2相隔: %d小时\n", betweenHour);
        long betweenMinute = ChronoUnit.MINUTES.between(birthday, now);
        System.out.printf("time1和time2相隔: %d分钟\n", betweenMinute);
        long betweenSecond = ChronoUnit.SECONDS.between(birthday, now);
        System.out.printf("time1和time2相隔: %d秒\n", betweenSecond);
    }
}
