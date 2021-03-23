package com.lijia.code.invokefactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Factory factory = new Factory();
            factory.getExecutor("test1").ifPresent(executor -> executor.execute());
            factory.getExecutor("test2").ifPresent(executor -> executor.execute());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
