package com.lijia.code;

public class Mock1 {
    public String hello(String a, String b){
        return Mock1.contact();
    }

    public static String contact(){
        System.out.println("=====");
        return "12345";
    }
}
