package com.lijia.code.timelimiter;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import io.github.resilience4j.timelimiter.TimeLimiter;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import io.github.resilience4j.timelimiter.TimeLimiterRegistry;
import io.vavr.control.Try;

import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.function.Supplier;

public class TimeLimiterTest1 {

    public static void main(String[] args) {
        RetryConfig retryConfig = RetryConfig.custom().maxAttempts(1)
                .retryOnException(throwable -> {
                    throwable.printStackTrace();
                    return true;
                })
                .build();
        RetryRegistry retryRegistry = RetryRegistry.of(retryConfig);
        Supplier<Future<Integer>> supplier = () -> create();
        TimeLimiterRegistry timeLimiterRegistry = TimeLimiterRegistry.of(TimeLimiterConfig.custom().cancelRunningFuture(true).timeoutDuration(Duration.ofMillis(1000)).build());
        TimeLimiter timeLimiter = timeLimiterRegistry.timeLimiter("test");
        Callable<Integer> callable = TimeLimiter.decorateFutureSupplier(timeLimiter, supplier);
        CircuitBreakerRegistry circuitBreakerRegistry = CircuitBreakerRegistry.of(CircuitBreakerConfig.ofDefaults());
        CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker("test");
        callable = CircuitBreaker.decorateCallable(circuitBreaker, callable);
        Retry retry = retryRegistry.retry("test");
        callable = Retry.decorateCallable(retry, callable);

        Integer r = Try.ofCallable(callable)
                .map(retu -> retu.intValue())
                .getOrElseGet(throwable -> {
                    System.out.println(throwable);
                    throwable.printStackTrace();
                    return 123;
                });
        System.out.println("------------------------"+r);

    }

    private static Future<Integer> create() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000* 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 0;
        });
    }


}
