package com.lijia.code;

import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CheckTimeout {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 100; i++) {
            Observable.fromCallable(() -> {
//                System.out.println("start..............");
//                System.out.println("end..............");
                System.out.println("inner----"+Thread.currentThread().getName());
//            Thread.sleep(2000L);
                return 0;
            })
                    .subscribeOn(Schedulers.io())
                    .timeout(3000L, TimeUnit.MILLISECONDS);
        }
        Integer retu = Observable.fromCallable(() -> {
            System.out.println("start..............");
            System.out.println("end..............");
            System.out.println("inner----"+Thread.currentThread().getName());
//            Thread.sleep(2000L);
            return 0;
        })
                .subscribeOn(Schedulers.io())
                .timeout(3000L, TimeUnit.MILLISECONDS).toBlocking().first();
        System.out.println(Thread.currentThread().getName());
        System.out.println("finish.............." + retu);
        Thread.sleep(1000* 60L);

    }
}
