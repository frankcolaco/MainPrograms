package com.examples.java.utils.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AtomicByteDemo {

    public static void main(String[] args) throws InterruptedException {
        AtomicByte atomicByte = new AtomicByte((byte)0b11111111);

        ExecutorService service = Executors.newFixedThreadPool(10);

        // We'll create seven threads to shift our initial pattern of all 1s
        // to the left by one. Eventually, we should see the pattern 10000000
        // i.e. a single one followed by seven zeros. We create seven threads
        // and each thread moves the pattern to the left by one.

        try {
            for(int i=0;i<7;i++){
                service.submit(atomicByte::shiftLeft);
            }
        }finally {
            service.shutdown();
            service.awaitTermination(2, TimeUnit.SECONDS);
        }

        atomicByte.print();
    }
}
