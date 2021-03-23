package com.lijia.code;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Testlog {
    static int sum = 0;
    public static void main(String[] args) throws InterruptedException {
        ThreadLocal threadLocal = new ThreadLocal();
        log.error("123 {},{}.{}",1,"23",null);


        CompletableFuture.runAsync(() -> System.out.println(Thread.currentThread().getName()));
        for(int j = 0 ;j < 10;j ++){
            CompletableFuture.runAsync(() -> {
                for(int i = 0; i< 100; i++){
                    sum = sum + i;
                }
            });
        }
        Thread.sleep(1000* 5L);
        System.out.println(sum);

//         Thread.currentThread().th
    }
}
