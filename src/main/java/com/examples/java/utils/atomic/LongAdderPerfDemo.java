package com.examples.java.utils.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class LongAdderPerfDemo {

    static AtomicLong atomicLong = new AtomicLong(0);
    static LongAdder longAdder = new LongAdder();

    public static void main(String[] args) throws InterruptedException {

        withAtomicLong();
        withLongAdder();

    }

    static void withAtomicLong() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(15);
        long start = System.currentTimeMillis();

        try {
            for (int i = 0; i < 10; i++) {
                service.submit(() -> {
                    for (int j = 0; j < 100000; j++) {
                        atomicLong.incrementAndGet();
                    }
                });
            }

        } finally {
            service.shutdown();
            service.awaitTermination(10, TimeUnit.SECONDS);
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("Time taken by atomic long " + end + " millis and count " + atomicLong.get());
    }

    static void withLongAdder() throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(15);

        long start = System.currentTimeMillis();
        try {
            for (int i = 0; i < 10; i++) {
                service.submit(() -> {
                    for (int j = 0; j < 100000; j++) {
                        longAdder.increment();
                    }
                });
            }

        } finally {
            service.shutdown();
            service.awaitTermination(10, TimeUnit.SECONDS);
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("Time taken by LongAdder " + end + " millis and count " + longAdder.sum());

    }
}
