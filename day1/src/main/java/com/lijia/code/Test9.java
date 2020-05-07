package com.lijia.code;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test9 {
    public static void main(String[] args) {
//        System.out.println(true|true);
//        System.out.println(false|false);
//        System.out.println(true|false);
//        System.out.println(false|true);
//
//        System.out.println(true&true);
//        System.out.println(false&false);
//        System.out.println(true&false);
//        System.out.println(false&true);

        ArrayList list = new ArrayList();

//        List list2 = new ArrayList();
        final List list2 = new CopyOnWriteArrayList();
        for(int i =0; i < 10000; i++){
            list.add(i);
        }
        list.parallelStream().forEach( i ->{
//                    System.out.println("start=>" +i);
////                    try {
////                        Thread.sleep(100);
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
////                    System.out.println("end=>" + i);
                    list2.add(i);
                }


                );
        System.out.println(list.size());
        System.out.println(list2.size());
    }
}
