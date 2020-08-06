package com.lijia.code;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class MDCTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executors = Executors.newCachedThreadPool();
        int count = 10000;
        CountDownLatch cdl = new CountDownLatch(count);
        for(int i = 0; i < count;i ++){
            executors.execute(()->{
                try{
                    byte[][] b = new byte[1024][1024];
                }finally {
                    cdl.countDown();
                }

            });
        }
        cdl.await();
        executors.shutdown();
    }
}
