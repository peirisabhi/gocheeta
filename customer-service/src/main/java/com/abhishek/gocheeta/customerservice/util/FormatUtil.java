package com.abhishek.gocheeta.customerservice.util;

import java.text.DecimalFormat;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-09-30
 * Time: 10:07
 */
public class FormatUtil {
    public static String getDoubleWithCents(double value) {

        DecimalFormat myFormatter = new DecimalFormat("###,###,###.##");
        myFormatter.setMinimumFractionDigits(2);
        String output = myFormatter.format(value);
        return output;

    }
}
