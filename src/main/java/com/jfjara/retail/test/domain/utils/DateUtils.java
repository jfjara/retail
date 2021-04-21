package com.jfjara.retail.test.domain.utils;

import com.jfjara.retail.test.domain.exceptions.AbstractCustomException;
import com.jfjara.retail.test.domain.exceptions.CustomFormatException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {

    public static Date formatDate(String dateText) throws AbstractCustomException {
        try {
            SimpleDateFormat isoFormat = new SimpleDateFormat(Constants.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS);
            isoFormat.setTimeZone(TimeZone.getTimeZone(Constants.UTC_TIMEZONE));
            Date date = isoFormat.parse(dateText);
            return date;
        } catch (Exception e) {
            throw new CustomFormatException();
        }
    }
}
