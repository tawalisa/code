package com.lijia.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class CallableDemo {

    static class ProductMode{
        String name;

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        int price;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "ProductMode{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
    static class Factory<T>{
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<ProductMode>> proceess(int count){
            List<Future<ProductMode>> retu = new ArrayList();
            List<Callable> list = new ArrayList();

            for (int i = 0; i < count; i++) {
                final int finalI = i;
                list.add(()->{
                    System.out.println("====================");
                    Thread.sleep(1000);
                    ProductMode mode = new ProductMode();
                    mode.setName("name"+finalI);
                    mode.setPrice(finalI);
                    return mode;
                });
//
//                executorService.submit(()->{
//                    System.out.println("====================");
//                    Thread.sleep(1000);
//                    ProductMode mode = new ProductMode();
//                    mode.setName("name"+finalI);
//                    mode.setPrice(finalI);
//                    return mode;
//                });
            }
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!");
            list.stream().forEach(callable -> retu.add(executorService.submit(callable)));
            return retu;
        }

        public void shutdowm() {
            executorService.shutdown();
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Factory<ProductMode> factory = new Factory();
        List<Future<ProductMode>> list = factory.proceess(100);
        for (Future<ProductMode> model:
             list) {
            System.out.println(model.get());

        }
        factory.shutdowm();
    }
}
