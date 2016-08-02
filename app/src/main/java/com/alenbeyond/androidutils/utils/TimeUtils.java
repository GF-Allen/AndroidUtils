package com.alenbeyond.androidutils.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by alenbeyond on 2016/7/12.
 */
public class TimeUtils {
    /**
     * 格式化yyyy-MM-dd时间成秒
     */
    public static String formatTimeMillis(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        try {
            return sdf.parse(date).getTime() / 1000 + "";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 格式化yyyy-MM-dd时间成毫秒
     */
    public static long formatTimeMillisl(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        try {
            return sdf.parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 格式化yyyy-MM-dd HH:mm:ss时间成毫秒
     */
    public static long getTimeMillislByYMDHMS(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
            return sdf.parse(date).getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 传入年月日，返回毫秒数
     */
    public static long getTimeMillis(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * 传入秒，返回yyyy-MM-dd
     */
    public static String formatTime(String time) {
        Long milliseconds = Long.valueOf(time + "000");
        return new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date(milliseconds));
    }

    /**
     * 获取本月后n月的时间
     */
    public static String getDate(int offset) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + offset);
        return new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(calendar.getTime());
    }

    /**
     * 获取当月的天数
     */
    public static int getCurrentMonthDay(Long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String data = sdf.format(new Date(time));
        int maxDate = new Date(Integer.valueOf(data.split("-")[0]), Integer.valueOf(data.split("-")[1]), 0).getDate();
        return maxDate;
    }
}
