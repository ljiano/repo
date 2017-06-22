package com.ljo.util;

/**
 * Created by jb.liang on 2017/6/22.
 */
public class StringUtil {

    public static String safeToString(Object o, String dv) {
        String r = dv;
        if (o != null) {
            r = String.valueOf(o);
        }
        return r;
    }
}
