package com.lijia.code.invokefactory;

@InvokeExecutor
public class Test1Executor implements Executor{
    @Override
    public String getName() {
        return "test1";
    }

    @Override
    public Object execute() {
        System.out.println("test1 is invoked.");
        return null;
    }
}
