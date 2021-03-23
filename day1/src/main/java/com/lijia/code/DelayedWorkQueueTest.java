package com.lijia.code;

import java.util.HashMap;
import java.util.concurrent.PriorityBlockingQueue;

public class DelayedWorkQueueTest {
    public static void main(String[] args) {
        System.out.println(10000000<Integer.MAX_VALUE);
        PriorityBlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue();
        for(int i = 10;i > 0; i--){
            priorityBlockingQueue.offer(i);
        }

//        for(int i = 0;i < 10; i++){
//            priorityBlockingQueue.offer(i);
//        }
        HashMap hashMap = null;
        priorityBlockingQueue.removeIf(integer -> integer>5);
        Integer i = null;
        do {

            i = priorityBlockingQueue.poll();
            System.out.println(i);
        }while(i!=null);

    }
}
