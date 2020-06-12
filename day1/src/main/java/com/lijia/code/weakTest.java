package com.lijia.code;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class weakTest {

    public static void main(String[] args) {
        int i = 0;
        ArrayList<WeakReference> array = new ArrayList();
        while(true){
            i++;
            array.add(new WeakReference(new Obj(i)));

            if(i%10 == 0 ){
                System.out.println(array.size());
                System.out.println(array.get(i -9).get());
            }
        }
    }

    static class Obj{
        int i;
        byte[] f;
        public Obj(int i){
            this.i = i;
            f = new byte[1024 * 1024 * 100];
        }

        @Override
        public String toString() {
            return i+"";
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("Obj： " + i + " finalize。");
        }
    }
}
