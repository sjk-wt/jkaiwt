package com.eliteams.quick4j.core.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by root on 16-9-30.
 */
public class DateFormatUtil {

    private static SimpleDateFormat sdf;

    public static Date Str2Date(String str) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 自定义转换格式
     * @param str
     * @param type
     * @return
     */
    public static Date Str2Date(String str, String type) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(type);
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date StrToDate(String str) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String DateToStr(Date date) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
        return str;
    }

    /**
     * 自定义格式
     * @param date
     * @param type
     * @return
     */
    public static String DateToStr(Date date, String type) {

        SimpleDateFormat format = new SimpleDateFormat(type);
        String str = format.format(date);
        return str;
    }

    /**
     * 获取当前时间 格式：yyyy-MM-dd HH:mm:ss.SSSZ
     *
     * @return
     */
    public static String getCurrentDataTime() {
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
        return sdf.format(new Date());
    }

    /**
     * 获取当前时间 格式：yyyyMMddHHmmssSSS
     *
     * @return
     */
    public static String getNowTime() {
        sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(new Date());
    }

    /**
     * 获取当前时间 格式：yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getNowDataTime() {
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    /**
     * 获取当前时间 格式：yyyy-MM-dd
     *
     * @return
     */
    public static String getData() {
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }

    /**
     *
     * @param date
     * @return
     */
    public static String getData(Date date) {
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public static String getData(Date date, String type) {
        sdf = new SimpleDateFormat(type);
        return sdf.format(date);
    }

    /**
     * 获取当前时间 格式：HH:mm:ss
     *
     * @return
     */
    public static String getTime() {
        sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date());
    }

    /**
     * 根据format获取时间格式,format不能为空
     *
     * @param format
     * @param date
     * @return
     */
    public static String getTime(String format, Date date) {
        if (date == null || format == null) return "";
        sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 获取当前时间 格式：yyyy-MM-dd HH:mm:ss.SSSZ
     *
     * @return
     */
    public static String formatDate(Date data) {
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
        return sdf.format(data);
    }

    /**
     * 将字符型转换为指定格式日期型
     *
     * @param _date  需要转换成日期的字符串
     * @param format 与需要转换成日期的字符串相匹配的格式
     * @return
     */
    public static Date stringToDate(String _date, String format) {
        if (null == format || "".equals(format)) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        sdf = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sdf.parse(_date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 将日期型转换为指定格式的字符串
     *
     * @param date   日期
     * @param format 格式
     * @return
     */
    public static String dateToString(Date date, String format) {
        if (null == format || "".equals(format)) {
            format = "yyyy年MM月dd日 hh点:mm分:ss秒";
        }
        sdf = new SimpleDateFormat(format);
        if (date == null)
            return "";
        return sdf.format(date);
    }

    /**
     * 获取时间戳 10位
     *
     * @return
     */
    public static String getCreateTime() {
        Date date = new Date();
        long time = date.getTime();

        String dateline = time + "";
        dateline = dateline.substring(0, 10);
        return dateline;
    }

    /**
     * 判断是否为今天
     *
     * @param date
     * @return
     */
    public static boolean isToday(Date date) {
        if (date == null) {
            return false;
        } else {
            Calendar appoint = Calendar.getInstance();
            appoint.setTime(date);
            Calendar toDay = Calendar.getInstance();
            if (toDay.get(Calendar.YEAR) == appoint.get(Calendar.YEAR)
                    && toDay.get(Calendar.MONTH) == appoint.get(Calendar.MONTH)
                    && toDay.get(Calendar.DAY_OF_MONTH) == appoint.get(Calendar.DAY_OF_MONTH)) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 增加几天
     *
     * @param date
     * @param days
     * @return
     */
    public static Date addNDay(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return calendar.getTime();
    }

    /**
     * 增加几月
     *
     * @param date
     * @param months
     * @return
     */
    public static Date addMonth(Date date, int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, months);
        return calendar.getTime();
    }

    /**
     * 相差秒
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int intervalSecond(Date date1, Date date2) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        long time1 = cal.getTimeInMillis();
        cal.setTime(date2);
        long time2 = cal.getTimeInMillis();
        long between_mins = (time2 - time1) / (1000);

        return Integer.parseInt(String.valueOf(between_mins));
    }

    /**
     * 相差分钟数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int intervalMin(Date date1, Date date2) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        long time1 = cal.getTimeInMillis();
        cal.setTime(date2);
        long time2 = cal.getTimeInMillis();
        long between_mins = (time2 - time1) / (1000 * 60);

        return Integer.parseInt(String.valueOf(between_mins));
    }

    /**
     * 相差几天
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int intervalDay(Date date1, Date date2) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        long time1 = cal.getTimeInMillis();
        cal.setTime(date2);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 相差几周
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int intervalWeek(Date date1, Date date2) {
        int days = intervalDay(date1, date2);
        return days / 7;
    }

    /**
     * 相差月数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int intervalMonth(Date date1, Date date2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTime(date1);
        c2.setTime(date2);

        int year = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
        int month = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);

        return year * 12 + month;
    }

    /**
     * 相差年数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int intervalYear(Date date1, Date date2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTime(date1);
        c2.setTime(date2);

        int years = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
        return years;
    }

    /**
     * 当前时间 加/减  分钟
     *
     * @param date
     * @param minute
     * @return
     */
    public static Date addMinute(Date date, int minute) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, minute);
        return c.getTime();
    }

    //addType:添加的日期类型：Calendar.YEAR、Calendar.MONTH等
    //addNum:添加的日期间隔：正数为+，负数为-
    public static String getAddTimeStr(int addType, int addNum) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(addType, calendar.get(addType) + addNum);
        Date now = calendar.getTime();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(now);
        return str;
    }

    //验证字符串是否为"yyyy-MM-dd"格式
    public static boolean isyyyyMMdd(String dateStr) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        if (dateStr.length() != 10) {
            return false;
        } else {
            try {
                Date date = format.parse(dateStr);
            } catch (ParseException e) {
                return false;
            }
        }
        return true;
    }

    /**
     * xgs秒拍有效时间转换
     * @param str
     * @param day
     * @return
     */
    public static Date xgsDate(String str, int day) {
        Date date = Str2Date(str, "yyyy-MM-dd HH:mm:ss");
        Date date2 = addNDay(date, day);
        return date2;
    }

    public static void main(String[] args) {
        System.out.println(DateFormatUtil.addMinute(new Date(), -5));
    }

}
