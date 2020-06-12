package com.lijia.code;

import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CheckTimeout1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> retu = Observable.fromCallable(() -> CompletableFuture.supplyAsync(() -> {
            System.out.println("start..............");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end..............");
            return 123;
        }))
                .subscribeOn(Schedulers.newThread())
                .timeout(500L, TimeUnit.MILLISECONDS).toBlocking().first();
        System.out.println("finish..............");
        System.out.println("finish.............." + retu.get());
    }
}
