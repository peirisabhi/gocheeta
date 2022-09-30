package com.abhishek.gocheeta.customerservice.util;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-11
 * Time: 12:01
 */
public class DateUtil {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private static final SimpleDateFormat dateFormatWithTime24 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final SimpleDateFormat dateFormatWithTime12 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aa");

    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

    public static String S(@NotNull Date date) {
        return dateFormat.format(date);
    }

    public static String getStringDateWith24Time(@NotNull Date date) {
        return dateFormatWithTime24.format(date);
    }

    public static String getStringDateWith12Time(@NotNull Date date) {
        return dateFormatWithTime12.format(date);
    }

    public static Date getDate(@NotNull String date) throws ParseException {
        return dateFormat.parse(date);
    }
    public static String getStringDate(@NotNull Date date) throws ParseException {
        return dateFormat.format(date);
    }

    public static Date getTime(@NotNull String time) throws ParseException {
        return timeFormat.parse(time);
    }

    public static String getStringTime(@NotNull Date time) throws ParseException {
        return timeFormat.format(time);
    }


    public static Date getTripEndTime(String now, int duration) {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        Date d = null;
        try {
            d = df.parse(now);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.MINUTE, duration);
//        String newTime = df.format(cal.getTime());
//        return newTime;
        return cal.getTime();
    }
}
