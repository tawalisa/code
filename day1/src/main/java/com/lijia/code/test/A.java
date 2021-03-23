package com.lijia.code.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class A{
  private String a1;

  public String getA1() {
   return a1;
  }

  public void setA1(String a1) {
   this.a1 = a1;
  }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
      A a = new A();
        Method m = a.getClass().getMethod("setA1", String.class);
        m.invoke(a,"aa");
        System.out.println(a.getA1());
    }
 }