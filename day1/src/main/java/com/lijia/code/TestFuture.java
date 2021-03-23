package com.lijia.code;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TestFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
            }
            return 100;
        }).thenApply(i -> i + 10);
        System.out.println(future.get());
        CompletableFuture<Void> r = CompletableFuture.runAsync(() -> {
            System.out.println("11111");
            throw new RuntimeException("123");
        });
        Thread.sleep(1000L);
        System.out.println("===");
        r.get();
    }
}
