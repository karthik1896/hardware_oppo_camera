package com.google.android.material.datepicker;

import android.os.Build;
import androidx.core.f.d;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

class DateStrings {
    private DateStrings() {
    }

    static String getYearMonthDay(long j) {
        return getYearMonthDay(j, Locale.getDefault());
    }

    static String getYearMonthDay(long j, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.getYearAbbrMonthDayFormat(locale).format(new Date(j));
        }
        return UtcDates.getMediumFormat(locale).format(new Date(j));
    }

    static String getMonthDay(long j) {
        return getMonthDay(j, Locale.getDefault());
    }

    static String getMonthDay(long j, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.getAbbrMonthDayFormat(locale).format(new Date(j));
        }
        return UtcDates.getMediumNoYear(locale).format(new Date(j));
    }

    static String getMonthDayOfWeekDay(long j) {
        return getMonthDayOfWeekDay(j, Locale.getDefault());
    }

    static String getMonthDayOfWeekDay(long j, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.getAbbrMonthWeekdayDayFormat(locale).format(new Date(j));
        }
        return UtcDates.getFullFormat(locale).format(new Date(j));
    }

    static String getYearMonthDayOfWeekDay(long j) {
        return getYearMonthDayOfWeekDay(j, Locale.getDefault());
    }

    static String getYearMonthDayOfWeekDay(long j, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.getYearAbbrMonthWeekdayDayFormat(locale).format(new Date(j));
        }
        return UtcDates.getFullFormat(locale).format(new Date(j));
    }

    static String getDateString(long j) {
        return getDateString(j, (SimpleDateFormat) null);
    }

    static String getDateString(long j, SimpleDateFormat simpleDateFormat) {
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(j);
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(j));
        }
        if (todayCalendar.get(1) == utcCalendar.get(1)) {
            return getMonthDay(j);
        }
        return getYearMonthDay(j);
    }

    static d<String, String> getDateRangeString(Long l, Long l2) {
        return getDateRangeString(l, l2, (SimpleDateFormat) null);
    }

    static d<String, String> getDateRangeString(Long l, Long l2, SimpleDateFormat simpleDateFormat) {
        if (l == null && l2 == null) {
            return d.a(null, null);
        }
        if (l == null) {
            return d.a(null, getDateString(l2.longValue(), simpleDateFormat));
        }
        if (l2 == null) {
            return d.a(getDateString(l.longValue(), simpleDateFormat), null);
        }
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(l.longValue());
        Calendar utcCalendar2 = UtcDates.getUtcCalendar();
        utcCalendar2.setTimeInMillis(l2.longValue());
        if (simpleDateFormat != null) {
            return d.a(simpleDateFormat.format(new Date(l.longValue())), simpleDateFormat.format(new Date(l2.longValue())));
        } else if (utcCalendar.get(1) != utcCalendar2.get(1)) {
            return d.a(getYearMonthDay(l.longValue(), Locale.getDefault()), getYearMonthDay(l2.longValue(), Locale.getDefault()));
        } else {
            if (utcCalendar.get(1) == todayCalendar.get(1)) {
                return d.a(getMonthDay(l.longValue(), Locale.getDefault()), getMonthDay(l2.longValue(), Locale.getDefault()));
            }
            return d.a(getMonthDay(l.longValue(), Locale.getDefault()), getYearMonthDay(l2.longValue(), Locale.getDefault()));
        }
    }
}
