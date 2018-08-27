package com.hk.rebirth.util.core;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:dongfei.xu
 * @Description:
 * @Date: 2018/8/19 15:48
 */
public class DateUtils {

    /**
     * @desc date转string
     * @date 15:02 2018/7/25
     */
    public static String formatDateTime(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
}
