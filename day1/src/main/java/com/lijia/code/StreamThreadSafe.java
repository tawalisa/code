package com.lijia.code;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class StreamThreadSafe {

    static List<Integer> metrics = new CopyOnWriteArrayList<>();

//    static LinkedBlockingQueue<Integer> metrics = new LinkedBlockingQueue();
//    static List<Integer> metrics = new ArrayList<>();
    public static void main(String[] args) {
        StreamThreadSafe main = new StreamThreadSafe();
        main.init(metrics);
        System.out.println("===============================");
        new Thread(()->{
            main.run();
        }).start();
        for(int i = 0; i< 100000; i ++){
            metrics.add(i);
        }

    }

    private void run() {


//        LinkedBlockingQueue<Integer> metrics;

        try {
            long batchesSent = 0;
            metrics.stream()
                    .collect(toBatches(20)).stream()
//                    .forEach( e-> fetch(e));
                    .forEach(this::fetch);
//                    .map()
//                    .forEach(System.out::println);
//                    .filter(e ->e)
//            metrics.clear();
            System.out.println("end--> "+ batchesSent);
//            Thread.sleep(1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void init(List<Integer> metrics) {
        for(int i = 0;i < 100000; i ++){
            metrics.add(i);
        }
    }
    private void init(LinkedBlockingQueue<Integer> metrics) {
        for(int i = 0;i < 100000; i ++){
            metrics.add(i);
        }
    }

    private boolean fetch(List<Integer> m){
//        throw new RuntimeException();
        System.out.println("fetch--> "+ m);
        System.out.println(m);
        return true;
    }
    public static <T> Collector<T, List<List<T>>, List<List<T>>> toBatches(int size) {
        return Collector.of(ArrayList::new,
                (list, value) -> {
                    List<T> batch = list.isEmpty() ? null : list.get(list.size() - 1);
                    if (batch == null || batch.size() == size) {
                        batch = new ArrayList<>(size);
                        list.add(batch);
                    }
                    batch.add(value);
                },
                (list1, list2) -> {
                    throw new UnsupportedOperationException();
                });
    }
}
