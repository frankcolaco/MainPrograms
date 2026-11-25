package com.examples.java.utils.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class LongPerf {

    static long simpleCounter;
    static AtomicLong atomicCounter;

    public static void main(String[] args) throws InterruptedException {
        test(false);
        test(true);
    }

    synchronized static void incrementSimpleCounter() {
        simpleCounter++;
    }

    static void test(boolean isAtomic) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);

        long start = System.currentTimeMillis();

        try {
            for (int j = 0; j < 10; j++) {

                service.submit(() -> {
                    for (int i = 0; i < 10000; i++) {
                        if (isAtomic) {
                            atomicCounter.incrementAndGet();
                        } else {
                            incrementSimpleCounter();
                        }
                    }
                });
            }
        } finally {
            service.shutdown();
            service.awaitTermination(10, TimeUnit.SECONDS);
        }
        long timeTaken = System.currentTimeMillis() - start;
        System.out.println("Time taken by " + (isAtomic ? "atomicCounter" : "simpleCounter") + " " + timeTaken + " millis");
    }
}
