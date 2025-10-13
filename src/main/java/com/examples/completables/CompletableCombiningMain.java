package com.examples.completables;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class CompletableCombiningMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /*
        if we need to run multiple futures in parallel and combine their results then we can use allOf() or anyOf() methods.
         */

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("future1");
            return 1;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("future2");
            return 5;
        });

        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("future3");
            return 10;
        });

        CompletableFuture<Integer> future4 = CompletableFuture.supplyAsync(() -> {
            System.out.println("future4");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 10;
        });

        CompletableFuture<Integer> future5 = CompletableFuture.supplyAsync(() -> {
            System.out.println("future5");
            return 2;
        });

        CompletableFuture<Void> resultFuture = CompletableFuture.allOf(future1,future3,future2);
        System.out.println(resultFuture.get());

        /*
         since allOf() returns CompletableFuture<Void>, we can't combine the result of all futures.
         we need to manually get the result of all futures
         we can use join() to combine the result of the futures
         */

        Optional<Integer> maxElement = Stream.of(future1,future2,future3)
                .map(CompletableFuture::join)
                .max(Integer::compareTo);

        System.out.println("max value::"+maxElement);

        CompletableFuture<Object> firstFuture = CompletableFuture.anyOf(future4,future5);
        System.out.println("First completed future:: "+firstFuture.get());


    }
}
