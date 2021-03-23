package com.lijia.code;

import com.google.common.util.concurrent.RateLimiter;

import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class RateLimiter1 {
    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = RateLimiter.create(400L,2, TimeUnit.SECONDS);
        for(int j = 0 ;j < 10;j ++){
            CompletableFuture.runAsync(() -> {
                while (true){
                    if(rateLimiter.tryAcquire(200)){
//                        rateLimiter.acquire(300);
                        System.out.println(Instant.now());
                    }else {
//                        System.out.println("==");
                    }

                }
            });
        }
        while(true){
            Thread.sleep(1000L);
        }
    }
}
