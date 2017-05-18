package com.andrepaiva.f1info.utils;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

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

    public static String adjustTimeZone(String raceTime){
        String newFormat = "hh:mm a";
        SimpleDateFormat sourceFormat = new SimpleDateFormat("HH:mm:ss'Z'", Locale.ENGLISH);
        sourceFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date parsed = null; // => Date is in UTC now
        try {
            parsed = sourceFormat.parse(raceTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        TimeZone tz = TimeZone.getDefault();
        SimpleDateFormat destFormat = new SimpleDateFormat(newFormat);
        destFormat.setTimeZone(tz);

        String result = destFormat.format(parsed);

        return result;
    }
}
