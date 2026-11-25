package com.examples.java.utils.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AtomicDoubleDemo {

    public static void main(String[] args) throws InterruptedException {

        AtomicDouble aDouble = new AtomicDouble(0.23d);

        ExecutorService service = Executors.newFixedThreadPool(10);

        // create 50 threads that each adds 0.17 a 1000 times. At the end our atomic
        // double should sum up to 8500.23 but you'll see a close enough value since
        // double isn't precise. However, multiple runs of the program should produce
        // the same value indicating the class AtomicDouble the thread-safe.
        try {
            for (int i = 0; i < 50; i++) {
                service.submit(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 1000; i++)
                            aDouble.getAndAdd(0.17d);
                    }
                });
            }
        } finally {
            service.shutdown();
            service.awaitTermination(1, TimeUnit.HOURS);
        }

        // print after the shift operations are complete
        System.out.println(aDouble.doubleValue());
    }
}
