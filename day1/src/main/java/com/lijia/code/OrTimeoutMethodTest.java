package com.lijia.code;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class OrTimeoutMethodTest {
    public static void main(String[] args) throws InterruptedException {
       log.info("start");
        int a = 10;
        int b = 15;
        CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return a + b;
        })
                .orTimeout(3, TimeUnit.SECONDS)
                .whenComplete((result, exception) -> {
                   log.info("whenComplete");
                    System.out.println(result);
                    if (exception != null)
                        exception.printStackTrace();
                });

       log.info("end");
        TimeUnit.SECONDS.sleep(10);
    }
}