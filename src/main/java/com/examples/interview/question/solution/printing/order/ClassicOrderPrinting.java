package com.examples.interview.question.solution.printing.order;

public class ClassicOrderPrinting {
    public static void main(String[] args) {

        OrderPrinting orderPrinting = new OrderPrinting();

        OrderPrintingThread t1 = new OrderPrintingThread(orderPrinting,"first");
        OrderPrintingThread t2 = new OrderPrintingThread(orderPrinting,"second");
        OrderPrintingThread t3 = new OrderPrintingThread(orderPrinting,"third");

        t2.start();
        t3.start();
        t1.start();
    }
}
