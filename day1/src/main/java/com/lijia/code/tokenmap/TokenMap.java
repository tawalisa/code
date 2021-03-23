package com.lijia.code.tokenmap;


import java.util.concurrent.ConcurrentHashMap;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TokenMap<T> {
//    ConcurrentHashMap<String, CredentialsWrapper<Supplier<T>>> map = new ConcurrentHashMap();
//    AtomicInteger version = new AtomicInteger(0);
//    Lock lock = new ReentrantLock();
//    public T put(String key , Supplier<T>  t, CredentialsWrapper<Supplier<T>> old){
//        lock.lock();
//        try{
//            CredentialsWrapper<Supplier<T>> theLastValue = map.get(key);
//            if(theLastValue == null){
//                CredentialsWrapper credentialsWrapper = new CredentialsWrapper(version.getAndIncrement(), Suppliers.memoize(t));
//                map.put(key, credentialsWrapper);
//                return credentialsWrapper.getT();
//            }else{
//                if(old == null){
//                    return theLastValue.getT().get();
//                }
//                if(old.getVersion() >= theLastValue.getVersion()){
//                    CredentialsWrapper credentialsWrapper = new CredentialsWrapper(version.getAndIncrement(), t);
//                    map.put(key, credentialsWrapper);
//                    return credentialsWrapper;
//                }else{
//                    return theLastValue;
//                }
//
//            }
//        }finally {
//            lock.unlock();
//        }
//
//
//    }
//    public CredentialsWrapper<Supplier<T>> get(String key){
//        return map.get(key);
//    }

}
