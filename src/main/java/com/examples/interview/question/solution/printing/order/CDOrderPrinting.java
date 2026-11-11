package com.examples.interview.question.solution.printing.order;

import java.util.concurrent.CountDownLatch;

public class CDOrderPrinting {

    CountDownLatch latch1;
    CountDownLatch latch2;

    public CDOrderPrinting() {
        latch1 = new CountDownLatch(1);
        latch2 = new CountDownLatch(1);
    }

    public void printFirst() {

        System.out.println("First");
        latch1.countDown();

    }

    public void printSecond() throws InterruptedException {
        latch1.await();
        System.out.println("Second");
        latch2.countDown();
    }

    public void printThird() throws InterruptedException {

        latch2.await();
        System.out.println("Third");
    }
}
