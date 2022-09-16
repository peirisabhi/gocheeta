package com.abhishek.gocheeta.customerservice.util;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public static String getStringDate(@NotNull Date date) {
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
}
