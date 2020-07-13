package com.lijia.code;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = new ThreadPoolExecutorWith(10, 10,
                100, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
//        executor.shutdown();
        Future<Void> retu = null;
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for(int ii = 0;ii<100;ii++){
            try {
                int finalIi = ii;
                retu = executor.submit((Callable<Void>) () -> {
                    for (int i = 0; i < 5; i++) {
                        Thread.sleep(1000L * 1L);
                        System.out.println(String.format("it is still running...%d== %d", finalIi, i));
                    }
                    System.out.println("completed");
                    return null;
                });
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        new Thread(()->{
            while(true){
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(executor);
            }

        }).start();
//        countDownLatch.await();
        Thread.sleep(1000L * 1L);
        executor.shutdown();
        retu = executor.submit((Callable<Void>) () -> {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000L * 1L);
                System.out.println(String.format("it is still running...%d== %d", 1000, i));
            }
            System.out.println("completed");
            return null;
        });
        System.out.println("===================");

    }

    static class ThreadPoolExecutorWith extends ThreadPoolExecutor{

        public ThreadPoolExecutorWith(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        }

        public ThreadPoolExecutorWith(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
        }

        public ThreadPoolExecutorWith(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
        }

        public ThreadPoolExecutorWith(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
        }

        @Override
        public String toString() {
            return "aaaaaa=>"+super.toString();
        }
    }
}
