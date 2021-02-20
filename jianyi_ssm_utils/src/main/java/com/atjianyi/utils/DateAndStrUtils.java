package com.atjianyi.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 简一
 * @className com.atjianyi.utils.DateAndStrUtils
 * @Date 2021/2/20 17:30
 **/
public class DateAndStrUtils {

    /**
     * 日期转换为字符串
     */
    public static String dateToStr(Date date,String patt){
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        String format = sdf.format(date);
        return format;
    }

    /**
     * 字符串转换为日期
     */
    public static Date strToDate(String date,String patt){
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date parse =null;
        try {
             parse = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;

    }
}
