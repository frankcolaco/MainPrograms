package com.examples.java.utils.locks.reentrant;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteReentrantLockWithRefreshDemo {

    private static Random random = new Random();
    private static boolean isDataFresh = true;

    public static void main(String[] args) throws Exception {

        ExecutorService service = Executors.newFixedThreadPool(15);

        Map<String, Object> cache = new HashMap<>();
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        cache.put("key", -1);

        Runnable writerThread = () -> writerThread(cache, lock);

        Runnable readThread = () -> readerThread(cache, lock);

        try {

            Future w1 = service.submit(writerThread);
            Future r1 = service.submit(readThread);
            Future r2 = service.submit(readThread);
            Future r3 = service.submit(readThread);
            Future r4 = service.submit(readThread);

            w1.get();
            r1.get();
            r2.get();
            r3.get();
            r4.get();


        } finally {
            service.shutdown();
        }

    }

    private static void writerThread(Map<String, Object> cache, ReentrantReadWriteLock lock) {

        for (int i = 0; i < 9; i++) {
            try {
                Thread.sleep(random.nextInt(50));
            } catch (InterruptedException e) {

            }
            lock.writeLock().lock();
            try {
                System.out.println("Acquired write lock ");
                isDataFresh=false;
            } finally {
                lock.writeLock().unlock();
            }
        }
    }

    private static void readerThread(Map<String, Object> cache, ReentrantReadWriteLock lock) {

        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(random.nextInt(100));
            } catch (InterruptedException e) {

            }

            lock.readLock().lock();
            try {

                if(!isDataFresh){
                    // unlock read lock first
                    lock.readLock().unlock();

                    // acquire write lock
                    lock.writeLock().lock();

                    try{
                        // check once again if the data is refreshed by another thread
                        if(!isDataFresh){
                            updateDate(cache);
                        }
                        //acquire read lock before releasing write lock. this is an example of downgrading from write to read lock.
                        //acquire read lock before releasing write lock. this is an example of downgrading from write to read lock.
                        lock.readLock().lock();

                    }finally {
                        lock.writeLock().unlock();
                    }
                }

                System.out.println("Acquire read lock and reading key:: " + cache.get("key"));
            } finally {
                lock.readLock().unlock();
            }
        }
    }

    private static void updateDate(Map<String,Object>cache){
        cache.put("key",random.nextInt(1000));
        isDataFresh=true;
    }
}

