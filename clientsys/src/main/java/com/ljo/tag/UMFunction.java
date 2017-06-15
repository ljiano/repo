package com.ljo.tag;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jb.liang on 2017/6/15.
 */
public class UMFunction {

    public static Log Logger = LogFactory.getLog(UMFunction.class);

    public static String formatDate(Date date, String format) {
        String value = "";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try{
            value = sdf.format(date);
        } catch(Exception e){
            Logger.error("日期格式转换失败！", e);
        }
        return value;
    }
}
