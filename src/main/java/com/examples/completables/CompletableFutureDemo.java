package com.examples.completables;

import java.util.concurrent.*;

public class CompletableFutureDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        CompletableFutureDemo completableFutureDemo = new CompletableFutureDemo();
        System.out.println("square:: "+completableFutureDemo.getSquareAsync(5).get());

        // runAsync() runs some background tasks asynchronously and returns a CompletableFuture<Void>.

        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() ->{
            try {
                System.out.println("Sleeping for 3 secs....");
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+" squaring in async:: "+ 5*5);
        });
        completableFuture.get();

        // we can also provide our own thread pool for execution of our future as below
        Executor executor = Executors.newSingleThreadExecutor();
        completableFuture = CompletableFuture.runAsync(() ->{
            try {
                System.out.println("Sleeping for 3 secs.... in private pool");
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+" squaring in async:: "+ 5*5);
        },executor);
        completableFuture.get();


        // if we need to get the result of computation then we can use supplyAsync()

        CompletableFuture<Integer> intCompleteable = CompletableFuture.supplyAsync(() -> completableFutureDemo.getSquare(4));
        System.out.println("Square using supplyAsync:: "+intCompleteable.get());

    }

    public CompletableFuture<Integer> getSquareAsync(int num) throws InterruptedException{
        CompletableFuture<Integer> completableFuture = CompletableFuture.completedFuture(num * num);
        return completableFuture;
    }

    public Integer getSquare(int num) {
        return num * num;
    }
}
