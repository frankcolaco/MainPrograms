package com.examples.interview.question.solution.barbershop;

import java.util.HashSet;
import java.util.Set;

public class BarberShopProblemDemo {

    public static void main(String[] args) throws InterruptedException {

        BarberShopProblemDemo.runTest();
    }

    public static void runTest() throws InterruptedException {
        BarberShopProblem barberShopProblem = new BarberShopProblem();
        Set<Thread> threads = new HashSet<>();
        Thread barberThread = new Thread(() -> {
            try {
                barberShopProblem.barber();
            } catch (InterruptedException ie) {
            }
        });
        barberThread.start();

        for (int i = 0; i < 10; i++) {
            Thread customerThread = new Thread(() -> {
                try {
                    barberShopProblem.customerWalksIn();
                } catch (InterruptedException ie) {

                }
            }, "Customer_Thread_" + i + 1);
            threads.add(customerThread);
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads)
            t.join();

        threads.clear();
        Thread.sleep(500);

        for (int i = 0; i < 5; i++) {
            Thread customerThread = new Thread(() -> {
                try {
                    barberShopProblem.customerWalksIn();
                } catch (InterruptedException ie) {

                }
            }, "Customer_Thread_" + i + 1);
            threads.add(customerThread);
        }

        for (Thread t : threads) {
            t.start();
            Thread.sleep(50);
        }

        barberThread.join();
    }
}
