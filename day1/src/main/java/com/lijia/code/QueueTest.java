package com.lijia.code;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Stream;

public class QueueTest {
    public static void main(String[] args) {

        //Given
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        for (int i = 0; i < 30; i++) {
            queue.offer(i);
        }

        //When and Then
        queue.stream().forEach(System.out::println);
        Stream.generate(() -> {
            try {
                return queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        })
//                .filter(x -> x !=null)
                .forEach(System.out::println);

        System.out.println("===");
    }
}
