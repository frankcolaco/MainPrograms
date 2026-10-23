package com.examples.interview.question.solution.readwritelock;

public class ReadWriteLockDemo {

    public static void main(String[] args) throws InterruptedException {
        final ReadWriteLock rwl = new ReadWriteLock();

        Thread t1 = new Thread(() -> {

            try {
                System.out.println("Attempting to acquire write lock in t1: " + System.currentTimeMillis());
                rwl.acquireWriteLock();
                System.out.println("write lock acquired: " + System.currentTimeMillis());

                for (; ; ) {
                    Thread.sleep(500);
                }

            } catch (InterruptedException e) {
            }
        });

        Thread t2 = new Thread(() -> {

            try {
                System.out.println("Attempting to acquire write lock in t2: " + System.currentTimeMillis());
                rwl.acquireWriteLock();
                System.out.println("write lock acquired: " + System.currentTimeMillis());

                for (; ; ) {
                    Thread.sleep(500);
                }

            } catch (InterruptedException e) {
            }
        });

        Thread t1Reader = new Thread(() ->{
            try{
                rwl.acquireReadLock();
                System.out.println("ReadLock Acquired: "+System.currentTimeMillis());
            }catch (InterruptedException ie){}
        });

        Thread t2Reader = new Thread(() ->{
                System.out.println("ReadLock about to release: "+System.currentTimeMillis());
                rwl.releaseReadLock();
                System.out.println("ReadLock released: "+System.currentTimeMillis());
        });

        t1Reader.start();
        t1.start();
        Thread.sleep(3000);
        t2Reader.start();
        Thread.sleep(1000);
        t2.start();
        t1Reader.join();
        t2Reader.join();
        t2.join();
    }
}
