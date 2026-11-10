package com.examples.interview.question.solution.stack.atomic;

import java.util.concurrent.*;

public class AtomicStackDemo {

    public static void main(String[] args) throws InterruptedException {

        NonBlockingStack<Integer> stack = new NonBlockingStack<>();
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        int numOfThreads = 2;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(numOfThreads);

        try{

            for(int i =0;i<numOfThreads;i++){
                executorService.submit(()->{
                    for(int j=0;j<10000;j++){
                        stack.push(j);
                    }

                    try{
                        cyclicBarrier.await();
                    } catch (InterruptedException | BrokenBarrierException e) {

                    }

                    for (int k = 0; k < 10000; k++) {
                        System.out.println("poping out:: "+ stack.pop());
                    }
                });
            }

        }finally {
            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        }
        System.out.println("Number of elements in the stack = " + stack.size());
    }
}
