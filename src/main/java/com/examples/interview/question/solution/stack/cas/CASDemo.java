package com.examples.interview.question.solution.stack.cas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CASDemo {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        int numOfThreads = 7;

        final SimulatedCompareAndSwap<Integer> sharedInt = new SimulatedCompareAndSwap<>(0);

        try {
            for (int i = 0; i < numOfThreads; i++) {
                executorService.submit(() -> {
                    int expectedValue;
                    int newValue;
                    int updateAttempt = 0;

                    do {
                        expectedValue = sharedInt.getValue();
                        newValue = expectedValue + 1;
                        System.out.println(Thread.currentThread().getName() + "update attempt number # " + updateAttempt);
                        updateAttempt++;
                    } while (!sharedInt.compareAndSet(expectedValue, newValue));
                });
            }
        }finally {
            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        }

        System.out.println("Final integer value = " + sharedInt.getValue());
    }
}
