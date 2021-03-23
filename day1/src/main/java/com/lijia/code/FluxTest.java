package com.lijia.code;


import rx.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

public class FluxTest {
    public static void main(String[] args) {
        Map map = new HashMap();

        map.put("1","a");
        map.put("2", "2");

        Map map1 = new HashMap();
//        map1.put("1","b");
//        map1.put("2","b");

        map1.putAll(map);
        System.out.println(map1);
        map1.put("1","b");
        System.out.println(map1);
        System.out.println(map);


    }

}
