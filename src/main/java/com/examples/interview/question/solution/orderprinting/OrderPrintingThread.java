package com.examples.interview.question.solution.orderprinting;

public class OrderPrintingThread extends Thread {

    private OrderPrinting orderPrinting;
    private String method;

    private CDOrderPrinting countDownOrderPrinting;

    public OrderPrintingThread(OrderPrinting orderPrinting, String method) {
        this.orderPrinting = orderPrinting;
        this.method = method;
    }

    public OrderPrintingThread(CDOrderPrinting countDownOrderPrinting, String method) {
        this.countDownOrderPrinting = countDownOrderPrinting;
        this.method = method;
    }

    @Override
    public void run() {
        if ("first".equals(method)) {
            if (orderPrinting != null) {
                orderPrinting.printFirst();
            } else if (countDownOrderPrinting != null) {
                countDownOrderPrinting.printFirst();
            }
        } else if ("second".equals(method)) {

            try {
                if (orderPrinting != null) {
                    orderPrinting.printSecond();
                } else if (countDownOrderPrinting != null) {
                    countDownOrderPrinting.printSecond();
                }
            } catch (InterruptedException e) {

            }
        } else if ("third".equals(method)) {

            try {
                if (orderPrinting != null) {
                    orderPrinting.printThird();
                } else if (countDownOrderPrinting != null) {
                    countDownOrderPrinting.printThird();
                }
            } catch (InterruptedException e) {

            }

        }
    }
}
