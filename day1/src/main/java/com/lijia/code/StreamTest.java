package com.lijia.code;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> a = new ArrayList();
        for(int i = 0 ;i < 1000;i++){
            a.add(i);
        }
        LongAdder longAdder = new LongAdder();
        for(int i = 0;i<5;i++){
            new Thread(()->{
                a.parallelStream().map(aa-> {

                    longAdder.increment();
                    System.out.println(Thread.currentThread().getName() + "==="+aa +"==" +longAdder.sum());
                    try {
                        Thread.sleep(50L* 1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return aa;
                }).collect(Collectors.toList());;
            }).start();
        }
        a.stream().map(aa-> {
            System.out.println("==========================================="+Thread.currentThread().getName() + "==="+aa +"==" +longAdder.sum());
            try {
                Thread.sleep(5L* 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return aa;
        }).collect(Collectors.toList());;
        Thread.sleep(100000L);
    }
}
