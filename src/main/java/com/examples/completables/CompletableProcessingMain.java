package com.examples.completables;

import java.util.concurrent.*;

public class CompletableProcessingMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFutureDemo completableFutureDemo = new CompletableFutureDemo();

        // thenApply() is used to process result of supplyAsync and return a future.
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
                    System.out.println(" supplyAsync "+Thread.currentThread().getName());
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return completableFutureDemo.getSquare(4);
                })
                .thenApply(num -> {
                    System.out.println("thenApply "+Thread.currentThread().getName());
                    return num+2;
                });

        System.out.println(Thread.currentThread().getName()+" "+integerCompletableFuture.get());

        //thenApplyAsync() will run individual threads for processing
        CompletableFuture<Integer>  integerCompletableFutureAsync = CompletableFuture.supplyAsync(() -> {
                    System.out.println(" supplyAsync "+Thread.currentThread().getName());
                     try {
                         TimeUnit.SECONDS.sleep(3);
                     } catch (InterruptedException e) {
                         throw new RuntimeException(e);
                     }
                     return completableFutureDemo.getSquare(4);
                })
                .thenApplyAsync(num -> {
                    System.out.println("thenApplyAsync "+Thread.currentThread().getName());
                    return num+2;
                });

        System.out.println(Thread.currentThread().getName()+" "+integerCompletableFutureAsync.get());

        // we can also have our own thread pool for which an overloaded method is provided
        Executor executor = Executors.newFixedThreadPool(3);
        CompletableFuture<Integer> integerCompletableFutureAsyncPrivatePool = CompletableFuture.supplyAsync(() -> {
                    System.out.println(" supplyAsync "+Thread.currentThread().getName());
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return completableFutureDemo.getSquare(4);
                },executor)
                .thenApplyAsync(num -> {
                    System.out.println("thenApplyAsync "+Thread.currentThread().getName());
                    return num+2;
                },executor);

        System.out.println(Thread.currentThread().getName()+" "+integerCompletableFutureAsyncPrivatePool.get());

        // thenAccept() is used if we don't want to return anything from callback methods.
        integerCompletableFutureAsyncPrivatePool = CompletableFuture.supplyAsync(() -> {
                    System.out.println(" supplyAsync "+Thread.currentThread().getName());
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return completableFutureDemo.getSquare(4);
                },executor)
                .thenApplyAsync(num -> {
                    System.out.println("thenApplyAsync "+Thread.currentThread().getName());
                    return num+2;
                },executor);

        System.out.println(Thread.currentThread().getName()+" "+integerCompletableFutureAsyncPrivatePool.thenAccept(num -> System.out.println("Number is:: "+num)));
        // thenRun() is also used if we don't want to return anything from callback function
        // thenRun() has no access to future's result

        integerCompletableFutureAsyncPrivatePool.thenRun(() -> System.out.println("Then Run"));
    }


}
