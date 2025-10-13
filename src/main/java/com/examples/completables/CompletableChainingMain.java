package com.examples.completables;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableChainingMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFutureDemo completableFutureDemo = new CompletableFutureDemo();
        /*
        in completable future we can chain two instances of completablefutures. Two methods that help us achieve it
            1. thenCompose()
            2. thenCombine()
         */

        // thenCompose() method takes Function as input i.e. it takes function result of previous computation as input and returns CompletableFuture as output
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
                    System.out.println(" supplyAsync "+Thread.currentThread().getName());
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return completableFutureDemo.getSquare(4);
                })
                .thenCompose(num -> {
                    System.out.println("thenCompose() ");
                       return CompletableFuture.supplyAsync(()-> num *2);
                });
        System.out.println(Thread.currentThread().getName()+" "+integerCompletableFuture.get());

        //thenCombine accepts Future and a BiFunction to process both results
        integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
                    System.out.println(" supplyAsync "+Thread.currentThread().getName());
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return completableFutureDemo.getSquare(4);
                })
                .thenCombine(CompletableFuture.supplyAsync(()-> 2),(num1,num2) -> num1 * num2);

        System.out.println(integerCompletableFuture.get()+" "+ Thread.currentThread().getName());
    }
}
