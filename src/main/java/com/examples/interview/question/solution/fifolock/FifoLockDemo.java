package com.examples.interview.question.solution.fifolock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class FifoLockDemo {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(10);
        FifoLock fifoLock = new FifoLock();

        try{
            for(int i=0;i<5;i++) {
                service.submit(()->{
                    for(int j=0;j<10;j++){
                        fifoLock.lock();
                        System.out.println(Thread.currentThread().getName()+ " acquires the lock.");

                        try{
                            Thread.sleep(ThreadLocalRandom.current().nextInt(20));
                        } catch (InterruptedException e) {

                        }
                        fifoLock.unlock();
                    }
                });
            }
        }finally {
            service.shutdown();
            service.awaitTermination(1, TimeUnit.MINUTES);
        }
        System.out.println("Main thread exiting successfully...");
    }
}
