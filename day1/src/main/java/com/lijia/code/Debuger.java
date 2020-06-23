package com.lijia.code;

import java.lang.reflect.Field;

public class Debuger {

    public static Object getArrt(Object obj, String attrName) throws NoSuchFieldException, IllegalAccessException {
        if (obj == null) {
            return null;
        }
        synchronized (obj) {
            Field f = obj.getClass().getDeclaredField(attrName);
            if (f.isAccessible()) {
                return f.get(obj);
            } else {
                f.setAccessible(true);
                Object retu = f.get(obj);
                f.setAccessible(false);
                return retu;
            }
        }
    }
}
