package com.lijia.code;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

/**
 * java.util.concurrent.RejectedExecutionException: Task java.util.concurrent.FutureTask@6895a785 rejected from java.util.concurrent.ThreadPoolExecutor@184f6be2[Terminated, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 0]
 * 	at java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2063)
 * 	at java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:830)
 * 	at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1379)
 * 	at java.util.concurrent.AbstractExecutorService.submit(AbstractExecutorService.java:112)
 * 	at java.util.concurrent.Executors$DelegatedExecutorService.submit(Executors.java:678)
 * 	at com.lijia.code.SingleThreadpool.main(SingleThreadpool.java:12)
 */
public class SingleThreadpoolRejectedExecutionException {
    public static void main(String[] args) throws InterruptedException {
        try{
            while(true){
                System.out.println("============================");
                CompletableFuture.supplyAsync(()->{
                    byte[] b = new byte[1024*1024*30];
                    System.out.println(Thread.currentThread().getName() + "==>>start");
                    System.out.println(Thread.currentThread().getName()+ "==>>end");
                    return 1;
                }, Executors.newSingleThreadExecutor());
//                Executors.newSingleThreadExecutor().submit(()->{
//                    byte[] b = new byte[1024*1024*30];
//                    System.out.println(Thread.currentThread().getName() + "==>>start");
//                    System.out.println(Thread.currentThread().getName()+ "==>>end");
//                });
                System.out.println("1111111111111111111111111111");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

//        ExecutorService aaa = Executors.newSingleThreadExecutor();
//        aaa.submit(()->{
//                System.out.println(Thread.currentThread().getName() + "==>>start");
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName()+ "==>>end");
//            });
//        Thread.sleep(1000*100);

    }
}
