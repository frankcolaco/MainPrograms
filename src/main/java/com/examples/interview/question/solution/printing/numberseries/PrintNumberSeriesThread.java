package com.examples.interview.question.solution.printing.numberseries;

public class PrintNumberSeriesThread implements Runnable {

    private PrintingNumberSeries printingNumberSeries;
    private String method;

    public PrintNumberSeriesThread(PrintingNumberSeries printingNumberSeries, String method) {
        this.printingNumberSeries = printingNumberSeries;
        this.method = method;
    }

    @Override
    public void run() {
        if ("zero".equals(method)) {
            try {
                printingNumberSeries.printZero();
            } catch (InterruptedException e) {

            }
        } else if ("odd".equals(method)) {
            try {
                printingNumberSeries.printOdd();
            } catch (InterruptedException e) {

            }
        } else if ("even".equals(method)) {
            try {
                printingNumberSeries.printEven();
            } catch (InterruptedException e) {

            }
        }
    }
}
