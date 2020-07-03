package com.lijia.code;

import java.util.concurrent.*;

public class CheckTimeout5 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Void> retu = null;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            Callable callable = (Callable<Void>) () -> {
                for (int i = 0; i < 100000; i++) {

//                    while(true){

//                        if(Thread.currentThread().isInterrupted())
//                            System.out.println(Thread.currentThread().isInterrupted());
                        Thread.sleep(1000L * 1L);
                        System.out.println(String.format("it is still running... %d", i));
//                    }
                }
                System.out.println(" sub thread completed");
                return null;
            };
            retu = executor.submit(callable);
            retu.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            System.out.println(e);

            retu.cancel(false);
        }finally {
            countDownLatch.countDown();
        }
        countDownLatch.await();
        executor.shutdown();


        
    }

}
