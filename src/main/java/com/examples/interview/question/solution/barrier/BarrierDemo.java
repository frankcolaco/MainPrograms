package com.examples.interview.question.solution.barrier;

public class BarrierDemo {

    public static void main(String[] args) throws InterruptedException {
        Barrier barrier = new Barrier(3);

        Thread t1 = new Thread(() -> {
            try {
                System.out.println("Thread 1 ");
                barrier.await();
                System.out.println("Thread 1 ");
                barrier.await();
                System.out.println("Thread 1 ");
                barrier.await();
            } catch (InterruptedException ie){

            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(500);
                System.out.println("Thread 2 ");
                barrier.await();
                Thread.sleep(500);
                System.out.println("Thread 2 ");
                barrier.await();
                Thread.sleep(500);
                System.out.println("Thread 2 ");
                barrier.await();
            } catch (InterruptedException ie){

            }
        });

        Thread t3 = new Thread(() -> {
            try {
                Thread.sleep(1500);
                System.out.println("Thread 3 ");
                barrier.await();
                Thread.sleep(1500);
                System.out.println("Thread 3 ");
                barrier.await();
                Thread.sleep(1500);
                System.out.println("Thread 3 ");
                barrier.await();
            } catch (InterruptedException ie){

            }
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

    }
}
