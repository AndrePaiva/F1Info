package com.andrepaiva.f1info.utils;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by andre on 23/04/2017.
 */

public class DateUtils {

    public static String adjustDate(String raceDate) {
        String newFormat = "EEE, d MMM yyyy";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            Date date = format.parse(raceDate);
            format.applyPattern(newFormat);
            raceDate = format.format(date);
        } catch (ParseException e) {
            Log.e("Date Parse Error: ",e.getMessage());
        }

        return raceDate;
    }
}
