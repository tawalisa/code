package com.lijia.code.hystrix;

import rx.Observable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class HystrixTest1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String s1 = new CommandHelloWorld("Bob").execute();
        System.out.println(s1);
        Future<String> s2 = new CommandHelloWorld("Bob").queue();
        System.out.println(s2.get());
        Observable<String> s3 = new CommandHelloWorld("Bob").observe();
        System.out.println(s3.toBlocking().first());
    }
}
