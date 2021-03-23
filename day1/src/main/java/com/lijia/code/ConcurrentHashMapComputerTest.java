package com.lijia.code;

import javax.sound.midi.SysexMessage;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ConcurrentHashMapComputerTest {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap();
        CompletableFuture.runAsync(()->{
            map.compute("1", (key, oldvalue) ->{
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                }
                System.out.println("-------");
//                map.put("1","3");
                return "2";
            });
        });
        while(true){
            System.out.println(map);
            Thread.sleep(100);
        }


    }
}
