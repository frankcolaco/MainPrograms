package com.examples.interview.question.solution.semaphore;

public class CountingSemaphoreDemo {

    public static void main(String[] args) throws InterruptedException {
        final CountingSemaphore cs = new CountingSemaphore(1);

        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    cs.acquire();
                    System.out.println("Ping: " + i);
                }
            } catch (InterruptedException e) {

            }
        });

        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    cs.release();
                    System.out.println("Pong: " + i);
                }
            } catch (InterruptedException is) {

            }
        });

        t2.start();
        t1.start();
        t2.join();
        t1.join();

    }
}
