package com.plunger.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    final static String datePattern = "yyyy-MM-dd HH:mm:ss";
    final static SimpleDateFormat sf = new SimpleDateFormat(datePattern);

    /**
     * 取回系统当前时间 时间格式yyyy-MM-dd hh:mm:ss
     *
     * @return yyyy-MM-dd hh:mm:ss格式的时间字符串
     */
    public static String getNowTime() {
        return sf.format(new Date());
    }
}
