package com.lijia.code;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
public class CompleteOnTimeOutMethodTest {
   public static void main(String args[]) throws InterruptedException {
      int a = 10;
      int b = 15;
      CompletableFuture.supplyAsync(() -> {
         try {
            System.out.println(Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(5);
         } catch(InterruptedException e) {
            e.printStackTrace();
         }
         return a + b;
      }).orTimeout(4, TimeUnit.SECONDS)
//      .completeOnTimeout(m1(), 4, TimeUnit.SECONDS)
      .thenAccept(result -> System.out.println(result));
      TimeUnit.SECONDS.sleep(10);
   }

   private static Integer m1() {
      return 1;
   }
}