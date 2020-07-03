package com.lijia.code;

import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CheckTimeout4 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {


        CompletableFuture<Integer> retu = Observable.fromCallable(() -> {


            return CompletableFuture.supplyAsync(()->{
                // here mock data fetch this is a async thread.
                try{
                    Thread.sleep(1000L * 5);
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println("inner----"+Thread.currentThread().getName());
                return 0;
            });


        })
        .subscribeOn(Schedulers.io())
        .timeout(1000L * 3L, TimeUnit.MILLISECONDS).toBlocking().first();

        System.out.println("==============================" + retu.get());
        Thread.sleep(1000L * 10L);
    }
}
