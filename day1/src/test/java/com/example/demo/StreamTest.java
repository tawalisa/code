package com.example.demo;

import com.google.common.base.Suppliers;
import org.junit.Test;

import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamTest {
    @Test
    public void test() {
        Object[] objs = {"0", "1", "2", "3"};
        Stream<Object> stream = Arrays.stream(objs);
        stream = stream.skip(1);
        stream.skip(2).forEach(System.out::println);
    }

    @Test
    public void test1() throws InterruptedException {
//        CompletableFuture<Integer> r = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(1000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return 100;
//        });
        Supplier<Integer> s = Suppliers.memoize(() -> {
            System.out.println("---------------" + Thread.currentThread().getName());
            return 1000;
        });

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            CompletableFuture.runAsync(() -> {
                System.out.println(finalI + "===" + s.get() + "---------------" + Thread.currentThread().getName());
            });
        }
        Thread.sleep(1000 * 10);
    }

    @Test
    public void test3() {
        ConcurrentHashMap<String, WeakReference<String>> map = new ConcurrentHashMap();
        map.put("1", new WeakReference<String>("1"));
        while (true){
            byte[][][] a = new byte[1024][1024][1024];
            System.out.println(map.get("1").get());
        }
    }
}
