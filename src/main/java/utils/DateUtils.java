package utils;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

import static java.time.temporal.ChronoField.DAY_OF_MONTH;
import static java.time.temporal.ChronoField.DAY_OF_YEAR;
import static java.time.temporal.ChronoUnit.MONTHS;
import static java.time.temporal.ChronoUnit.YEARS;
import static java.time.temporal.TemporalAdjusters.*;

public class DateUtils {
    public static void main(String[] args) {
        //1，获取当前系统时间
        Date date = new Date();

        //2，Date转为DateTime
        DateTime dateTime = new DateTime(date.getTime());

        //3，DateTime转为Date
        Date date1 = dateTime.toDate();

        //4，获取日期格式,
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //5，Date转换为String类型格式
        String dateStr = df.format(new Date());

    }

    /**
     * 获取默认时间格式: yyyy-MM-dd HH:mm:ss
     */
    private static final DateTimeFormatter DEFAULT_DATETIME_FORMATTER = TimeFormat.LONG_DATE_PATTERN_LINE.formatter;
    private static final DateTimeFormatter DEFAULT_DATETIME_FORMATTER2 = TimeFormat.TIME_PATTERN2.formatter;
    private static final DateTimeFormatter DEFAULT_DATETIME_FORMATTER3 = TimeFormat.SHORT_DATE_PATTERN_LINE.formatter;

    public static final String DEFAULT_DATETIME_FORMATTER_FOR_DATE = "yyyy-MM-dd HH:mm:ss";
    public static final String SHORT_DATETIME_FORMATTER_FOR_DATE = "yyyy-MM-dd";
    public static final String CONTINUOUS_DATETIME_FORMATTER_FOR_DATE = "yyyyMMddHHmmss";


    private DateUtils() {
    }

    /**
     * String 转时间
     *
     * @param timeStr
     * @return
     */
    public static LocalDateTime parseString2LocalDateTime(String timeStr) {
        return LocalDateTime.parse(timeStr, DEFAULT_DATETIME_FORMATTER);
    }

    public static Date parseString2Date(String timeStr) {
        Date date = null;
        if (!StringUtils.isBlank(timeStr)) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATETIME_FORMATTER_FOR_DATE);
                date = sdf.parse(timeStr);
            } catch (Exception e) {
                System.out.println("[ERROR] parseString2Date Exception" + timeStr);
            }
        }
        return date;
    }

    public static Date parseString2ShorteDate(String timeStr) {
        Date date = null;
        if (!StringUtils.isBlank(timeStr)) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(SHORT_DATETIME_FORMATTER_FOR_DATE);
                date = sdf.parse(timeStr);
            } catch (Exception e) {
                System.out.println("[ERROR] parseString2Date Exception" + timeStr);
            }
        }
        return date;
    }

    public static Date parseConString2Date(String timeStr) {
        Date date = null;
        if (!StringUtils.isBlank(timeStr)) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(CONTINUOUS_DATETIME_FORMATTER_FOR_DATE);
                date = sdf.parse(timeStr);
            } catch (Exception e) {
                System.out.println("[ERROR] parseString2Date Exception" + timeStr);
            }
        }
        return date;
    }

    public static String getStringDate(Date date) {
        String dateString = "";
        if (date != null) {
            SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_DATETIME_FORMATTER_FOR_DATE);
            dateString = formatter.format(date);
        }
        return dateString;
    }

    public static String getStringShortDate(Date date) {
        String dateString = "";
        if (date != null) {
            SimpleDateFormat formatter = new SimpleDateFormat(SHORT_DATETIME_FORMATTER_FOR_DATE);
            dateString = formatter.format(date);
        }
        return dateString;
    }

    public static String getStringDate(Date date, String format) {
        String dateString = "";
        if (date != null) {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            dateString = formatter.format(date);
        }
        return dateString;
    }


    public static Date getBeginOfDate(Date date) {
        if (null == date) {
            throw new IllegalArgumentException("date不能为空");
        }

        SimpleDateFormat shortFormatter = new SimpleDateFormat(SHORT_DATETIME_FORMATTER_FOR_DATE);

        String sourceString = shortFormatter.format(date);

        SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_DATETIME_FORMATTER_FOR_DATE);
        try {
            return formatter.parse(sourceString + " 00:00:00");
        } catch (Exception e) {
            throw new RuntimeException("获取date开始时间 date 00:00:00错误");
        }

    }

    public static Date getEndOfDate(Date date) {
        if (null == date) {
            throw new IllegalArgumentException("date不能为空");
        }

        SimpleDateFormat shortFormatter = new SimpleDateFormat(SHORT_DATETIME_FORMATTER_FOR_DATE);

        String sourceString = shortFormatter.format(date);

        SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_DATETIME_FORMATTER_FOR_DATE);
        try {
            return formatter.parse(sourceString + " 23:59:59");
        } catch (Exception e) {
            throw new RuntimeException("获取date结束时间 date 23:59:59错误");
        }

    }

    public static Date parseString2Date(String timeStr, String format) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            return formatter.parse(timeStr);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * String 转时间
     *
     * @param timeStr
     * @param format  时间格式
     * @return
     */
    public static LocalDateTime parseString2LocalDateTime(String timeStr, TimeFormat format) {
        return LocalDateTime.parse(timeStr, format.formatter);
    }


    public static LocalDate parseString2LocalDate(String timeStr, TimeFormat format) {
        return LocalDate.parse(timeStr, format.formatter);
    }

    /**
     * 时间转 String
     *
     * @param localDateTime
     * @return
     */
    public static String getStringLocalDateTime(LocalDateTime localDateTime) {
        return DEFAULT_DATETIME_FORMATTER.format(localDateTime);
    }


    /**
     * 时间转 String
     *
     * @param time
     * @param format 时间格式
     * @return
     */
    public static String getStringLocalDateTime(LocalDateTime time, TimeFormat format) {
        return format.formatter.format(time);
    }


    public static String getStringLocalDate(LocalDate time, TimeFormat format) {
        return format.formatter.format(time);
    }


    /**
     * Date转换为LocalDateTime
     *
     * @param date
     */
    public static LocalDateTime date2LocalDateTime(Date date) {
        Instant instant = date.toInstant();
        //An instantaneous point on the time-line.(时间线上的一个瞬时点。)
        ZoneId zoneId = ZoneId.systemDefault();
        //A time-zone ID, such as {@code Europe/Paris}.(时区)
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return localDateTime;
    }

    /**
     * LocalDateTime转换为Date
     *
     * @param localDateTime
     */
    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        //Combines this date-time with a time-zone to create a  ZonedDateTime.
        Date date = Date.from(zdt.toInstant());
        return date;
    }

    /**
     * LocalTime转换为Date
     *
     * @param localTime
     */
    public static Date localDateTime2Date(LocalTime localTime) {
        LocalTime localTime1 = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime1);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);
        return date;
    }


    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurrentDatetime() {
        return DEFAULT_DATETIME_FORMATTER.format(LocalDateTime.now());
    }


    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurrentDatetime2() {
        return DEFAULT_DATETIME_FORMATTER2.format(LocalDateTime.now());
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurrentDatetime3() {
        return DEFAULT_DATETIME_FORMATTER3.format(LocalDateTime.now());
    }


    /**
     * 获取当前时间
     *
     * @param format 时间格式
     * @return
     */
    public static String getCurrentDatetime(TimeFormat format) {
        return format.formatter.format(LocalDateTime.now());
    }


    /**
     * 时间格式
     */
    public enum TimeFormat {


        /**
         * 短时间格式
         */
        SHORT_DATE_PATTERN_CHINESE("yyyy年MM月dd日"),
        SHORT_DATE_PATTERN_LINE("yyyy-MM-dd"),
        SHORT_DATE_PATTERN_SLASH("yyyy/MM/dd"),
        SHORT_DATE_PATTERN_DOUBLE_SLASH("yyyy\\MM\\dd"),
        SHORT_DATE_PATTERN_NONE("yyyyMMdd"),
        TIME_PATTERN("HH:mm:ss"),
        TIME_PATTERN2("HH:mm"),


        /**
         * 长时间格式
         */
        LONG_DATE_PATTERN_LINE("yyyy-MM-dd HH:mm:ss"),
        LONG_DATE_PATTERN_SLASH("yyyy/MM/dd HH:mm:ss"),
        LONG_DATE_PATTERN_DOUBLE_SLASH("yyyy\\MM\\dd HH:mm:ss"),
        LONG_DATE_PATTERN_NONE("yyyyMMdd HH:mm:ss"),


        /**
         * 长时间格式 带毫秒
         */
        LONG_DATE_PATTERN_WITH_MILSEC_LINE("yyyy-MM-dd HH:mm:ss.SSS"),
        LONG_DATE_PATTERN_WITH_MILSEC_SLASH("yyyy/MM/dd HH:mm:ss.SSS"),
        LONG_DATE_PATTERN_WITH_MILSEC_DOUBLE_SLASH("yyyy\\MM\\dd HH:mm:ss.SSS"),
        LONG_DATE_PATTERN_WITH_MILSEC_NONE("yyyyMMdd HH:mm:ss.SSS");


        private transient DateTimeFormatter formatter;

        TimeFormat(String pattern) {
            formatter = DateTimeFormatter.ofPattern(pattern);
        }
    }

    /**
     * 转换日期[yyyy-MM-dd]的时间范围--前一天
     *
     * @param date 日期
     * @return [0]:日期的最小时间  [1]:日期的最大时间
     */
    public static Date[] formatDate(Date date) {
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        Date beforeOneDay = calendar.getTime();
        String start = sdf2.format(beforeOneDay) + " 00:00:00";
        String end = sdf2.format(date) + " 23:59:59";

        Date[] d = new Date[2];
        try {
            d[0] = sdf3.parse(start);
            d[1] = sdf3.parse(end);
        } catch (Exception e) {
            d[0] = date;
            d[1] = date;
        }
        return d;
    }


    /**
     * 转换日期[yyyy-MM-dd]的时间范围--当天
     *
     * @param date 日期
     * @return [0]:日期的最小时间  [1]:日期的最大时间
     */
    public static Date[] formatCurrentDate(Date date) {
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Date beforeOneDay = calendar.getTime();
        String start = sdf2.format(beforeOneDay) + " 00:00:00";
        String end = sdf2.format(date) + " 23:59:59";

        Date[] d = new Date[2];
        try {
            d[0] = sdf3.parse(start);
            d[1] = sdf3.parse(end);
        } catch (Exception e) {
            d[0] = date;
            d[1] = date;
        }
        return d;
    }


    /**
     * 获取Period（时间段）
     *
     * @param lt 较小时间
     * @param gt 较大时间
     * @return
     */
    public static Period localDateDiff(LocalDate lt, LocalDate gt) {
        Period p = Period.between(lt, gt);
        return p;
    }


    /**
     * 获取时间间隔，并格式化为XXXX年XX月XX日
     *
     * @param lt 较小时间
     * @param gt 较大时间
     * @return
     */
    public static String localDateDiffFormat(LocalDate lt, LocalDate gt) {
        Period p = Period.between(lt, gt);
        String str = String.format(" %d年 %d月 %d日", p.getYears(), p.getMonths(), p.getDays());
        return str;
    }


    /**
     * 获取Duration（持续时间）
     *
     * @param lt 较小时间
     * @param gt 较大时间
     * @return
     */
    public static Duration localTimeDiff(LocalTime lt, LocalTime gt) {
        Duration d = Duration.between(lt, gt);
        return d;
    }


    /**
     * 获取时间间隔（毫秒）
     *
     * @param lt 较小时间
     * @param gt 较大时间
     * @return
     */
    public static long millisDiff(LocalTime lt, LocalTime gt) {
        Duration d = Duration.between(lt, gt);
        return d.toMillis();
    }


    /**
     * 获取时间间隔（秒）
     *
     * @param lt 较小时间
     * @param gt 较大时间
     * @return
     */
    public static long secondDiff(LocalTime lt, LocalTime gt) {
        Duration d = Duration.between(lt, gt);
        return d.getSeconds();
    }


    /**
     * 获取时间间隔（天）
     *
     * @param lt 较小时间
     * @param gt 较大时间
     * @return
     */
    public static long daysDiff(LocalDate lt, LocalDate gt) {
        long daysDiff = ChronoUnit.DAYS.between(lt, gt);
        return daysDiff;
    }

    public static long hoursDiff(LocalDateTime lt, LocalDateTime gt) {
        long hoursDiff = ChronoUnit.HOURS.between(lt, gt);
        return hoursDiff;
    }

    public static long minutesDiff(LocalDateTime lt, LocalDateTime gt) {
        long minutesDiff = ChronoUnit.MINUTES.between(lt, gt);
        return minutesDiff;
    }

    public static long secondsDiff(LocalDateTime lt, LocalDateTime gt) {
        long secondsDiff = ChronoUnit.SECONDS.between(lt, gt);
        return secondsDiff;
    }

    /**
     * 获得月初第一天的00：00
     *
     * @return
     */
    public static Date getFirstDayBeginTimeOfCurMonth() {
        return DateUtils.localDateTime2Date(DateUtils.getFirstDayOfMonthBeginTime(DateUtils.date2LocalDateTime(new Date())));
    }

    /**
     * 创建一个新的日期，它的值为上月的第一天
     *
     * @param date
     * @return
     */
    public static LocalDate getFirstDayOfLastMonth(LocalDate date) {
        return date.with((temporal) -> temporal.with(DAY_OF_MONTH, 1).plus(-1, MONTHS));


    }

    /**
     * 创建一个新的日期，它的值为上月的最后一天
     *
     * @param date
     * @return
     */
    public static LocalDate getLastDayOfLastMonth(LocalDate date) {
        return date.with((temporal) -> temporal.with(DAY_OF_MONTH, temporal.range(DAY_OF_MONTH).getMaximum()).plus(-1, MONTHS));


    }

    /**
     * 创建一个新的日期，它的值为当月的第一天
     *
     * @param date
     * @return
     */
    public static LocalDate getFirstDayOfMonth(LocalDate date) {
        return date.with(firstDayOfMonth());
    }

    public static LocalDateTime getFirstDayOfMonthBeginTime(LocalDateTime date) {
        LocalDateTime beginDateTime = date.with(TemporalAdjusters.firstDayOfMonth()).withHour(0).withMinute(0).withSecond(0);
        return beginDateTime;
    }

    /**
     * 创建一个新的日期，它的值为当月的最后一天
     *
     * @param date
     * @return
     */
    public static LocalDate getLastDayOfMonth(LocalDate date) {
        return date.with(lastDayOfMonth());
    }

    /**
     * 创建一个新的日期，它的值为下月的第一天
     *
     * @param date
     * @return
     */
    public static LocalDate getFirstDayOfNextMonth(LocalDate date) {
        return date.with(firstDayOfNextMonth());


    }

    /**
     * 创建一个新的日期，它的值为下月的最后一天
     *
     * @param date
     * @return
     */
    public static LocalDate getLastDayOfNextMonth(LocalDate date) {
        return date.with((temporal) -> temporal.with(DAY_OF_MONTH, temporal.range(DAY_OF_MONTH).getMaximum()).plus(1, MONTHS));


    }


    /**
     * 创建一个新的日期，它的值为上年的第一天
     *
     * @param date
     * @return
     */
    public static LocalDate getFirstDayOfLastYear(LocalDate date) {
        return date.with((temporal) -> temporal.with(DAY_OF_YEAR, 1).plus(-1, YEARS));
    }

    /**
     * 创建一个新的日期，它的值为上年的最后一天
     *
     * @param date
     * @return
     */
    public static LocalDate getLastDayOfLastYear(LocalDate date) {
        return date.with((temporal) -> temporal.with(DAY_OF_YEAR, temporal.range(DAY_OF_YEAR).getMaximum()).plus(-1, YEARS));
    }


    /**
     * 创建一个新的日期，它的值为当年的第一天
     *
     * @param date
     * @return
     */
    public static LocalDate getFirstDayOfYear(LocalDate date) {
        return date.with(firstDayOfYear());
    }


    /**
     * 创建一个新的日期，它的值为今年的最后一天
     *
     * @param date
     * @return
     */
    public static LocalDate getLastDayOfYear(LocalDate date) {
        return date.with(lastDayOfYear());
    }


    /**
     * 创建一个新的日期，它的值为明年的第一天
     *
     * @param date
     * @return
     */
    public static LocalDate getFirstDayOfNextYear(LocalDate date) {
        return date.with(firstDayOfNextYear());
    }


    /**
     * 创建一个新的日期，它的值为明年的最后一天
     *
     * @param date
     * @return
     */
    public static LocalDate getLastDayOfNextYear(LocalDate date) {
        return date.with((temporal) -> temporal.with(DAY_OF_YEAR, temporal.range(DAY_OF_YEAR).getMaximum()).plus(1, YEARS));
    }


    /**
     * 创建一个新的日期，它的值为同一个月中，第一个符合星期几要求的值
     *
     * @param date
     * @return
     */
    public static LocalDate getFirstInMonth(LocalDate date, DayOfWeek dayOfWeek) {
        return date.with(firstInMonth(dayOfWeek));
    }


    /**
     * 创建一个新的日期，并将其值设定为日期调整后或者调整前，第一个符合指定星 期几要求的日期
     *
     * @param date
     * @return
     */
    public static LocalDate getNext(LocalDate date, DayOfWeek dayOfWeek) {
        return date.with(next(dayOfWeek));
    }


    /**
     * 创建一个新的日期，并将其值设定为日期调整后或者调整前，第一个符合指定星 期几要求的日期
     *
     * @param date
     * @return
     */
    public static LocalDate getPrevious(LocalDate date, DayOfWeek dayOfWeek) {
        return date.with(previous(dayOfWeek));
    }


    /**
     * 创建一个新的日期，并将其值设定为日期调整后或者调整前，第一个符合指定星 期几要求的日期，如果该日期已经符合要求，直接返回该对象
     *
     * @param date
     * @return
     */
    public static LocalDate getNextOrSame(LocalDate date, DayOfWeek dayOfWeek) {
        return date.with(nextOrSame(dayOfWeek));
    }


    /**
     * 创建一个新的日期，并将其值设定为日期调整后或者调整前，第一个符合指定星 期几要求的日期，如果该日期已经符合要求，直接返回该对象
     *
     * @param date
     * @return
     */
    public static LocalDate getPreviousOrSame(LocalDate date, DayOfWeek dayOfWeek) {
        return date.with(previousOrSame(dayOfWeek));
    }

    /**
     * 获取指定日期的日开始时间。
     */
    public static LocalDateTime getDateStart(LocalDateTime date) {
        return LocalDateTime.of(date.toLocalDate(), LocalTime.MIN);
    }

    /**
     * 获取指定日期的日开始时间。
     */
    public static LocalDateTime getDateEnd(LocalDateTime date) {
        return LocalDateTime.of(date.toLocalDate(), LocalTime.MAX);
    }

    /**
     * 获取当天制定时间
     *
     * @param day
     * @param minute
     * @param second
     * @return
     * @throws Exception
     */
    public static Date getPresentData(Integer day, Integer minute, Integer second) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, day);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        Date date = calendar.getTime();

        return date;
    }

    /**
     * 当天的开始时间
     *
     * @return
     */
    public static Date startOfTodDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 当天的结束时间
     *
     * @return
     */
    public static Date endOfTodDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    /**
     * 获得当前日期的前几天
     *
     * @param interval
     * @return
     */
    public static Date getCurrentBeforeDay(int interval) {
        return DateUtils.localDateTime2Date(DateUtils.date2LocalDateTime(new Date()).minusDays(interval));
    }

    /**
     * 获得指定时间的开始时间
     *
     * @param date
     * @return
     */
    public static Date getBeginTimeOfDay(Date date) {
        LocalDateTime localDateTime = DateUtils.date2LocalDateTime(date).withHour(0).withMinute(0).withSecond(0);
        return DateUtils.localDateTime2Date(localDateTime);
    }

    /**
     * 是否为当月1号
     */
    public static boolean isFirstDay() {
        //可以对每个时间域单独修改
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DATE);
        return day == 1;
    }

}
