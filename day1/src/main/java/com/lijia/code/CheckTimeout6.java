package com.lijia.code;

import rx.Observable;
import rx.Subscription;
import rx.observables.BlockingObservable;
import rx.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class CheckTimeout6 {
    public static void main(String[] args) throws InterruptedException {

        List<Observable<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            list.add( Observable.fromCallable(() -> {
                System.out.println("start----" + finalI);
                Thread.sleep(1000L);
                System.out.println("end----" + finalI);
                return finalI;
            })
//                    .subscribeOn(Schedulers.computation())
            );
        }
        System.out.println("=====");
        list.stream().forEach(retu -> retu.subscribeOn(Schedulers.computation()).observeOn(Schedulers.computation()).subscribe(r->System.out.println(r)));

        Thread.sleep(100000L);


    }
}
