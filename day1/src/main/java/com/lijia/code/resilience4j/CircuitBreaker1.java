package com.lijia.code.resilience4j;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;

import java.util.function.Function;

public class CircuitBreaker1 {
    public static void main(String[] args) {
//        CircuitBreakerRegistry circuitBreakerRegistry
//                = CircuitBreakerRegistry.ofDefaults();

        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .failureRateThreshold(20)
                .ringBufferSizeInClosedState(5)
                .build();

        CircuitBreakerRegistry registry = CircuitBreakerRegistry.of(config);
        CircuitBreaker circuitBreaker = registry.circuitBreaker("my");
        Service service = new Service();
        Function<Integer, Integer> decorated = CircuitBreaker
                .decorateFunction(circuitBreaker, service::process);

//        for (int i = 0; i < 10; i++) {
//            try {
//                decorated.apply(i);
//
//            } catch (CircuitBreakerOpenException ce){
//
//            } catch(Exception ignore) {ignore.printStackTrace();}
//        }
    }
    static class Service implements RemoteService{
        public int process(int i){
            System.out.println(i);
            throw new RuntimeException();
        }
    }
    static interface RemoteService {
        int process(int i);
    }
}
