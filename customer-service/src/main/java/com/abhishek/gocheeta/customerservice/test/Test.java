package com.abhishek.gocheeta.customerservice.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-09-29
 * Time: 17:07
 */
public class Test {
    public static void main(String[] args) {
        String myTime = "14:10";
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        Date d = null;
        try {
            d = df.parse(myTime);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.MINUTE, 180);
        String newTime = df.format(cal.getTime());

        System.out.println(newTime);
    }
}
