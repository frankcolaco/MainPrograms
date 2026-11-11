package com.examples.interview.question.solution.printing.numberseries;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PrintNumberSeriesDemo {

    public static void main(String[] args) throws InterruptedException {
        PrintingNumberSeries printingNumberSeries = new PrintingNumberSeries(10);
        PrintNumberSeriesThread t1 = new PrintNumberSeriesThread(printingNumberSeries, "zero");
        PrintNumberSeriesThread t2 = new PrintNumberSeriesThread(printingNumberSeries, "even");
        PrintNumberSeriesThread t3 = new PrintNumberSeriesThread(printingNumberSeries, "odd");

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        try {
            executorService.submit(t2);
            executorService.submit(t1);
            executorService.submit(t3);
        } finally {
            executorService.shutdown();
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        }
    }
}
