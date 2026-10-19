package com.examples;

import java.util.concurrent.CountDownLatch;

public class DeadLockDemo {

    public static void main(String[] args) {
        Deadlock deadlock = new Deadlock();
        try {
            deadlock.runTest();
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
}

class Deadlock {
    private int counter = 0;
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    CountDownLatch latch = new CountDownLatch(2);

    Runnable incrementer = () -> {
        try {
            for (int i = 0; i < 100; i++) {
                incrementCounter();
                System.out.println("Incrementing " + i);
            }
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    };

    Runnable decrementer = () -> {
        for (int i = 0; i < 100; i++) {
            decrementCounter();
            System.out.println("Decrementing " + i);
        }
    };

    public void runTest() throws InterruptedException {
        Thread thread1 = new Thread(incrementer);
        Thread thread2 = new Thread(decrementer);

        thread1.start();
        Thread.sleep(100);
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Done : " + counter);
    }

    void incrementCounter() throws InterruptedException {
        synchronized (lock1) {
            latch.countDown();
            System.out.println("Acquired lock1");
            latch.await();
            synchronized (lock2) {
                counter++;
            }
        }
    }

    void decrementCounter() {
        synchronized (lock1) {
            System.out.println("Acquired lock2");
            latch.countDown();
            synchronized (lock2) {
                counter--;
            }
        }
    }
}
