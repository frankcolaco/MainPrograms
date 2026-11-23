package com.examples.java.utils.locks.stamped;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

public class WriteStampedLockDemo {

    public static void main(String[] args) throws InterruptedException {
        try (ExecutorService service = Executors.newFixedThreadPool(10)) {

            StampedLock stampedLock = new StampedLock();

            // main thread acquires the write lock before spawning read thread.
            long writeStamp = stampedLock.writeLock();

            try{
                service.submit(()->{
                    System.out.println("Attempting to acquire read lock");
                    long readStamp = stampedLock.readLock();
                    System.out.println("Read lock acquired");
                    stampedLock.unlock(readStamp);
                });
                Thread.sleep(3000);
            }finally{
                System.out.println("write lock being released");
                stampedLock.unlock(writeStamp);

                // wait for read thread to exit
                service.shutdown();
                service.awaitTermination(1, TimeUnit.MINUTES);
            }
        }
    }
}
