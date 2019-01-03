package com.xin.activity.util;

import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author three
 * @since 2019/1/2 16:27
 * <p>
 *
 * </p>
 */
public class DateUtil extends DateUtils {
    //获得周几
    public static String getWeekRank(Date date) {
        return new SimpleDateFormat("EEEE").format(date);
    }
}
