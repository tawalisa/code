package com.lijia.code;

import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TestThreadPool {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ThreadPoolExecutor executor = new NameDefaultThreadPoolExecutor(
                10,
                10,
                10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), TestThreadPool.class.getSimpleName());

        Future<Object> re = executor.submit(() -> {
            return Thread.currentThread().getName();
        });
        System.out.println("sub-thread name:" + re.get());
        System.out.println(executor);
        System.out.println("==================");
        executor.shutdown();
    }

    public static class NameDefaultThreadPoolExecutor extends ThreadPoolExecutor {

        final private String poolName;

        public NameDefaultThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, String name) {
            super(
                    corePoolSize,
                    maximumPoolSize,
                    keepAliveTime, unit, workQueue, NamedDefaultThreadFactory.of(name));
            this.poolName = name;

        }

        @Override
        public String toString() {
            return poolName + "-" + super.toString();
        }
    }

    public static class NamedDefaultThreadFactory implements ThreadFactory {
        private static final Map<String, AtomicInteger> poolNumberMap = new ConcurrentHashMap();
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        public static NamedDefaultThreadFactory of(String name) {
            return new NamedDefaultThreadFactory(name);
        }

        private NamedDefaultThreadFactory(String name) {
            AtomicInteger poolNumber = getPoolNumberForName(name);
            SecurityManager s = System.getSecurityManager();
            this.group = s != null ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.namePrefix = "pool-" + name + "-" + poolNumber.getAndIncrement() + "-thread-";
        }

        public Thread newThread(Runnable r) {
            Thread t = new Thread(this.group, r, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (t.isDaemon()) {
                t.setDaemon(false);
            }

            if (t.getPriority() != 5) {
                t.setPriority(5);
            }

            return t;
        }

        private static AtomicInteger getPoolNumberForName(String name) {
            AtomicInteger poolNumber = poolNumberMap.get(name);
            if (poolNumber == null) {
                Class var2 = NamedDefaultThreadFactory.class;
                synchronized (NamedDefaultThreadFactory.class) {
                    poolNumber = poolNumberMap.get(name);
                    if (poolNumber == null) {
                        poolNumber = new AtomicInteger(1);
                        poolNumberMap.put(name, poolNumber);
                    }
                }
            }

            return poolNumber;
        }
    }

}
