package com.lijia.code;

import java.util.LinkedHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap map = new LinkedHashMap(8000,0.75f,true);
        for(int i = 0;i< 10000 ;i++){
            map.put(i,i);
        }

        ExecutorService executors = Executors.newFixedThreadPool(100);
        for(int i = 0;i < 100; i++){
            executors.execute(()->{
                while(true){
                    for(int ii = 0;ii< 10000; ii++){
                        if(!map.get(ii).equals(ii)){
                            System.out.println(Thread.currentThread().getName() + "=="+ii);
                        }
                    }
                }


            });
        }
        
    }
}
