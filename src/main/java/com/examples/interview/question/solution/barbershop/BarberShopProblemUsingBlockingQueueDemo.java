package com.examples.interview.question.solution.barbershop;

public class BarberShopProblemUsingBlockingQueueDemo {

    public static void main(String[] args) throws Exception {
        final BarberShopProblemUsingBlockingQueue shop = new BarberShopProblemUsingBlockingQueue();

        Thread barber = new Thread(() -> {
            try {
                shop.barberWorks();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        barber.start();

        for (int i = 1; i <= 8; i++) {
            BarberShopProblemUsingBlockingQueue.Customer c = new BarberShopProblemUsingBlockingQueue.Customer(i);
            Thread customerThread = new Thread(() -> {
                try {
                    shop.customerWalksIn(c);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            customerThread.start();
            Thread.sleep(50);
        }
    }

}
