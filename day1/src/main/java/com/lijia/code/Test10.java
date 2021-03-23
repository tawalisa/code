package com.lijia.code;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Test10 {
    public static void main(String[] args) throws InterruptedException {
//        ThreadPoolExecutor executorService = new ThreadPoolExecutor(100, 100,
//                60, SECONDS, new LinkedBlockingQueue<>());
//        for(int i = 0;i< 10000; i++){
//            int finalI = i;
//            executorService.execute(()-> {
//                System.out.println(Thread.currentThread().getName()+"=="+ finalI);
//                try {
//                    Thread.sleep(10000L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        }
//        System.out.println("====");
//        Thread.sleep(1000*1000);

        CompletableFuture<Integer> a = CompletableFuture.supplyAsync(() -> {
            return 1 ;
        }).thenApply(i -> {
            System.out.println("thenApply-->"+i);
            return i/0;
        }).exceptionally(throwable -> {
                    System.out.println("exceptionally-->"+throwable);
                    return 0;
                }
        ).whenComplete((i, throwable) -> {
            System.out.println("whenComplete-->"+i +" throwable->"+throwable);
        });
        try {
            System.out.println(a.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
