package com.examples.java.utils.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * this class implemented two counters to test their performance in multi-threaded environment.
 * 1 counter is simple and other is atomic
 */
public class IntegerPerf {

    static AtomicInteger aCounter = new AtomicInteger(0);
    static int simpleCounter =0;

    public static void main(String[] args) throws InterruptedException {
        test(true);
        test(false);
    }

    synchronized static void incrementSimpleCounter(){
        simpleCounter++;
    }
    synchronized static void test(boolean isAtomic) throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(10);

        long start = System.currentTimeMillis();

        try{
            for(int i=0;i<10;i++){
                service.submit(()->{
                    for(int j=0;j<100000;j++){
                        if(isAtomic){
                            aCounter.incrementAndGet();
                        }else {
                            incrementSimpleCounter();
                        }
                    }
                });
            }
        }finally {
            service.shutdown();
            service.awaitTermination(45, TimeUnit.MILLISECONDS);
        }

        long timeTaken = System.currentTimeMillis() - start;
        System.out.println("Time taken by "+ (isAtomic ? "atomic counter ": "simple counter ") +timeTaken +" millis");
    }

}
