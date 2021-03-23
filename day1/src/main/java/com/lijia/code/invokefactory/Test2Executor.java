package com.lijia.code.invokefactory;

@InvokeExecutor
public class Test2Executor implements Executor{
    @Override
    public String getName() {
        return "test2";
    }

    @Override
    public Object execute() {
        System.out.println("test2 is invoked.");
        return null;
    }
}
