package com.examples.interview.question.solution.barbershop;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

public class BarberShopProblemUsingBlockingQueue {

    static final int CHAIRS = 3;

    static class Customer {
        final int id;
        final CountDownLatch haircutDone;

        Customer(int id) {
            this.id = id;
            this.haircutDone = new CountDownLatch(1);
        }
    }

    private final BlockingQueue<Customer> waitingRoom = new ArrayBlockingQueue<>(CHAIRS);

    public void customerWalksIn(Customer customer) throws InterruptedException {
        if (!waitingRoom.offer(customer)) {
            System.out.println("Customer " + customer.id + " leaves: no chair available");
            return;
        }

        System.out.println("Customer is waiting for barber");
        customer.haircutDone.await();
        System.out.println("Customer " + customer.id + " leaves the chair");
    }

    public void barberWorks() throws InterruptedException {
        while (true) {
            Customer customer = waitingRoom.take();// barber waits for next customer
            System.out.println("Barber starts haircut for customer: " + customer.id);

            Thread.sleep(100);
            System.out.println("Barber finishes haircut for customer " + customer.id);
            customer.haircutDone.countDown();// signal that customer can leave
        }
    }
}
