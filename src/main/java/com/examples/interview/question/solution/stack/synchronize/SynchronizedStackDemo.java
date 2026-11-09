package com.examples.interview.question.solution.stack.synchronize;

import java.util.concurrent.*;

public class SynchronizedStackDemo {

    public static void main(String[] args) throws InterruptedException {
        SynchronizedStack<Integer> stackOfInts = new SynchronizedStack<>();
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        int numOfThreads = 2;
        CyclicBarrier barrier = new CyclicBarrier(numOfThreads);
        Integer testValue = 51;

        try{
            for(int i=0;i<numOfThreads;i++){
                executorService.submit(()->{
                   for(int j=0;j<10000;j++){
                       stackOfInts.push(j);
                       try {
                           barrier.await();
                       } catch (InterruptedException | BrokenBarrierException e) {
                           System.out.println("ignore exception");
                       }

                       for (int k = 0; k < 10000; k++) {
                           stackOfInts.pop();
                       }
                   }
                });
            }
        }finally{
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        }
    }
}
