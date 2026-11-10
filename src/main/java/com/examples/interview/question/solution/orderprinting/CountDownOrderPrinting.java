package com.examples.interview.question.solution.orderprinting;

public class CountDownOrderPrinting {

    public static void main(String[] args) {

        CDOrderPrinting countDownOrderPrinting = new CDOrderPrinting();

        OrderPrintingThread t1 = new OrderPrintingThread(countDownOrderPrinting, "first");
        OrderPrintingThread t2 = new OrderPrintingThread(countDownOrderPrinting, "second");
        OrderPrintingThread t3 = new OrderPrintingThread(countDownOrderPrinting, "third");

        t3.start();
        t2.start();
        t1.start();


    }
}
