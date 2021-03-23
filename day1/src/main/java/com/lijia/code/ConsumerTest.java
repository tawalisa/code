package com.lijia.code;

import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                //这里其实类似回调函数，你在这里处理结果
                System.out.println(s);
            }
        };
        consumer.accept("123");
    }
}
