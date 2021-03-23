package com.lijia.code;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public class Test12345 {
    public static void main(String[] args) {
        Map map = new HashMap();

        Map map1 = new HashMap();
        for(int i = 0; i <100; i++){
            map1.put(""+i, i);
        }


        Map map2 = new HashMap();
        for(int i = 0; i <100; i++){
            map2.put(""+i, i);
        }

        map.put(map1,123);
        map.put(map2,123);
        System.out.println(map.size());
        System.out.println(map.get(map1));
        System.out.println(map.get(map2));
//        System.out.println(String.format("%daaa+%s---%s---%s",3,null,new Object(), true) );
//        Map<Integer, Integer> map1 = new HashMap();
//        for(int i = 0; i < 10; i ++){
//            map1.put(i, i);
//        }
//        map1.values().stream().filter(i -> i%2==0).forEach(v -> v.);
//        BigDecimal bigDecimal = new BigDecimal("123.40000");
//        System.out.println(bigDecimal.toString());
//        Map<Integer, Integer> map = new ConcurrentHashMap<>();
//        for (int i = 0; i < 10000; i++) {
//            map.put(i, i);
//        }
//        CompletableFuture.runAsync(() -> {
//            int i = 0;
//            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//                map.remove(i);
//                i++;
//            }
//        });

//        int i = 9999;
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey());
//            map.remove(i);
//            i--;
//        }
//        System.out.println(map.size());
//        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
//            map.remove(entry.getKey());
//        }
    }
}
