package com.lijia.code;

import java.util.concurrent.*;

public class TestThreadPool {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10,
                10,
                10, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        Future<Object> re = executor.submit(() -> {
            throw new RuntimeException();
        });
        System.out.println(re.get());
        Thread.sleep(1000L * 2L);
        System.out.println("==================");
    }
}
