package com.examples.java.utils.locks.stamped;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

public class ReadStampedLockDemo {

    public static void main(String[] args) throws InterruptedException {
        try (ExecutorService service = Executors.newFixedThreadPool(10)) {

            StampedLock stampedLock = new StampedLock();

            // main thread attempts to acquire the lock twice, which is granted.
            long readStamp = stampedLock.readLock();
            long readStamp1 = stampedLock.readLock();

            try {
                for (int i = 0; i < 3; i++) {
                    service.submit(() -> {

                        long runnableReadStamp = stampedLock.readLock();
                        System.out.println("Read lock count in spawned thread:: " + stampedLock.getReadLockCount());
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {

                        } finally {
                            stampedLock.unlockRead(runnableReadStamp);
                        }
                    });
                }
            } finally {
                service.shutdown();
                service.awaitTermination(1, TimeUnit.MINUTES);
                stampedLock.unlockRead(readStamp);
                stampedLock.unlockRead(readStamp1);
            }
            System.out.println("Read lock count in main thread:: " + stampedLock.getReadLockCount());
            System.out.println("stampedLock.isReadLocked():: " + stampedLock.isReadLocked());
        }
    }
}
