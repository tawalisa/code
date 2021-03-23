package com.lijia.code;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.function.Supplier;

public class ConcurrentModificationExceptionTest {
    static class Obj {
        int i;

        public Obj(int i) {
            this.i = i;
        }

        public void say() {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        ExecutorService executors = Executors.newFixedThreadPool(100);
        ArrayList<Obj> abc = new ArrayList();
        Obj obj1 = new Obj(10000);
        for (int i = 0; i < 1000; i++) {
            abc.add(new Obj(i));
        }
        abc.add(obj1);

        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            abc.add(obj1);
            return null;
        });
        Supplier s = ()-> {
            for (Obj o : abc) {
                o.say();
            }
            return null;
        };
        CompletableFuture<Object> r = CompletableFuture.supplyAsync(() -> {
            try {
                return s.get();
            } catch (RuntimeException e) {
                e.printStackTrace();
                throw e;
            }
        }, executors);

//        CompletableFuture.allOf(r).join();




    }
}
