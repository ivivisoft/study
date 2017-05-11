package com.ivivisoft.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dafei on 2017/5/4.
 * 时间转换工具类
 */
public class TimeUtil {
    // 时间戳转换
    public static String timestampTotime(long timestamp, String type) {
        SimpleDateFormat sdf = new SimpleDateFormat(type);
        Date date = new Date(timestamp);
        return sdf.format(date);
    }
}
