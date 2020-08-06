package com.lijia.code;

import java.util.concurrent.*;

public class CacheThreadTest {
    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        ExecutorService excutors = null;
//        excutors = Executors.newCachedThreadPool();
//        excutors = new ThreadPoolExecutor(1000,1000,60L,TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
        excutors = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        while(true){
            excutors.submit(()->{
//                byte[] b = new byte[1024*1024*30];
                if(!map.contains(Thread.currentThread().getName() )){
                    map.put(Thread.currentThread().getName(), Thread.currentThread().getName());
                }else{
                    System.out.println(Thread.currentThread().getName());
                }

                System.out.println(Thread.currentThread().getName() + "==>>start");
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+ "==>>end");
            });
        }
    }
}
