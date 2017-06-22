package com.ljo.util;

/**
 * Created by jb.liang on 2017/6/22.
 */
public class NumberUtil {

    public static Integer safeToInteger(Object o, Integer dv) {
        Integer r = dv;
        if (o != null) {
            try {
                r = new Integer(String.valueOf(o));
            } catch (Exception ex) {
            }
        }
        return r;
    }
}
