package com.study.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;

public class DateTimeUtils {
    public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        System.out.println("返回当前的日期：" + getCurrentLocalDate());
        System.out.println("返回当前日期时间：" + getCurrentLocalDateTime());
        System.out.println("返回当前日期字符串(yyyyMMdd)：" + getCurrentDateStr());
        System.out.println("返回当前日期时间字符串(yyyyMMddHHmmss)：" + getCurrentDateTimeStr());
        LocalDate startDateInclusive = LocalDate.of(2019, 06, 04);
        LocalDate endDateExclusive = LocalDate.of(2019, 06, 05);
        System.out.println("日期相隔天数：" + periodDays(startDateInclusive, endDateExclusive));
        String dt = "2019年06月04日";
        String dt2 = "2019年06月05日";
        SimpleDateFormat sd = new SimpleDateFormat("yyyy年MM月dd日");
        try {
            Instant start = sd.parse(dt).toInstant();
            Instant end = sd.parse(dt2).toInstant();
            System.out.println("日期相隔小时：" + durationHours(start, end));
            System.out.println("日期相隔分钟：" + durationMinutes(start, end));
            System.out.println("日期相隔毫秒数：" + durationMillis(start, end));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LocalDate today = LocalDate.of(2019, 06, 05);
        System.out.println("是否当天：" + isToday(today));
        System.out.println("获取本月的第一天：" + getFirstDayOfThisMonth());
        System.out.println("获取本月的最后一天：" + getLastDayOfThisMonth());
        System.out.println("获取2017-01的第一个周一：" + getFirstMonday());
        System.out.println("获取当前日期的后两周：" + getCurDateAfterTwoWeek());
        System.out.println("获取当前日期的6个月后的日期：" + getCurDateAfterSixMonth());
        System.out.println("获取当前日期的5年后的日期：" + getCurDateAfterFiveYear());
        System.out.println("获取当前日期的20年后的日期：" + getCurDateAfterTwentyYear());
    }

    /**
     * 返回当前日期
     *
     * @return
     */
    public static LocalDate getCurrentLocalDate() {
        return LocalDate.now();
    }

    /**
     * 返回当前日期时间
     *
     * @return
     */
    public static LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now();
    }

    /**
     * 返回当前日期字符串：yyyyMMdd
     *
     * @return
     */
    public static String getCurrentDateStr() {
        return LocalDate.now().format(DATE_FORMATTER);
    }

    /**
     * 返回当前日期时间字符串：yyyyMMddHHmmss
     *
     * @return
     */
    public static String getCurrentDateTimeStr() {
        return LocalDateTime.now().format(DATETIME_FORMATTER);
    }

    /**
     * 将日期字符串格式化为LocalDate
     *
     * @param dateStr 日期字符串
     * @param pattern 格式模式
     * @return
     */
    public static LocalDate parseLocalDate(String dateStr, String pattern) {
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 将日期字符串格式化为LocalDateTime
     *
     * @param dateTimeStr 日期时间字符串
     * @param pattern     格式模式
     * @return
     */
    public static LocalDateTime parseLocalDateTime(String dateTimeStr, String pattern) {
        return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 两个日期相隔天数
     *
     * @param startDateInclusive 开始日期
     * @param endDateExclusive   结束日期
     * @return
     */
    public static int periodDays(LocalDate startDateInclusive, LocalDate endDateExclusive) {
        return Period.between(startDateInclusive, endDateExclusive).getDays();
    }

    /**
     * 两个日期相隔小时
     *
     * @param startInclusive 开始日期
     * @param endExclusive   结束日期
     * @return
     */
    public static long durationHours(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toHours();
    }

    /**
     * 两个日期相隔分钟
     *
     * @param startInclusive 开始日期
     * @param endExclusive   结束日期
     * @return
     */
    public static long durationMinutes(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toMinutes();
    }

    /**
     * 两个日期相隔毫秒数
     *
     * @param startInclusive 开始日期
     * @param endExclusive   结束日期
     * @return
     */
    public static long durationMillis(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toMillis();
    }

    /**
     * 指定日期是否为当天
     *
     * @param date 指定日期
     * @return
     */
    public static boolean isToday(LocalDate date) {
        return getCurrentLocalDate().equals(date);
    }

    /**
     * 获取本月第一天
     *
     * @return
     */
    public static String getFirstDayOfThisMonth() {
        return getCurrentLocalDate().with(TemporalAdjusters.firstDayOfMonth()).format(DATE_FORMATTER);
    }

    /**
     * 获取本月最后一天
     *
     * @return
     */
    public static String getLastDayOfThisMonth() {
        return getCurrentLocalDate().with(TemporalAdjusters.lastDayOfMonth()).format(DATE_FORMATTER);
    }

    /**
     * 获取2017-01的第一个周一
     *
     * @return
     */
    public static String getFirstMonday() {
        return LocalDate.parse("2017-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)).format(DATE_FORMATTER);
    }

    /**
     * 获取当前日期的后两周
     *
     * @return
     */
    public static String getCurDateAfterTwoWeek() {
        return getCurrentLocalDate().plus(2, ChronoUnit.WEEKS).format(DATE_FORMATTER);
    }

    /**
     * 获取当前日期的6个月后的日期
     *
     * @return
     */
    public static String getCurDateAfterSixMonth() {
        return getCurrentLocalDate().plus(6, ChronoUnit.MONTHS).format(DATE_FORMATTER);
    }

    /**
     * 获取当前日期的5年后的日期
     *
     * @return
     */
    public static String getCurDateAfterFiveYear() {
        return getCurrentLocalDate().plus(5, ChronoUnit.YEARS).format(DATE_FORMATTER);
    }

    /**
     * 获取当前日期的20年后的日期
     *
     * @return
     */
    public static String getCurDateAfterTwentyYear() {
        return getCurrentLocalDate().plus(2, ChronoUnit.DECADES).format(DATE_FORMATTER);
    }

    /**
     * 字符串转时间
     *
     * @return
     */
    public static LocalDate stringToDate(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(time, formatter);
    }
}
