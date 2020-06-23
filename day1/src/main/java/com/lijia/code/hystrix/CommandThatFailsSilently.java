package com.lijia.code.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class CommandThatFailsSilently extends HystrixCommand<String> {

    private final boolean throwException;

    public CommandThatFailsSilently(boolean throwException) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.throwException = throwException;
    }

    @Override
    protected String run() {
        if (throwException) {
            throw new RuntimeException("failure from CommandThatFailsFast");
        } else {
            return "success";
        }
    }

//    @Override
//    protected String getFallback() {
//        return "fail";
//    }

    public static void main(String[] args) {
//        System.out.println(new CommandThatFailsSilently(true).execute());
//        System.out.println(new CommandThatFailsSilently(false).execute());
        try{
            System.out.println(new CommandThatFailsSilently(true).execute());
//            System.out.println(new CommandThatFailsSilently(false).execute());
        }catch (Exception e){
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

}