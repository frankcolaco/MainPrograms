package com.examples.completables;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;

public class AreaOfRectangleMain {

      private static BiFunction<Integer,Integer,Integer> areaOfRectangle = (number, number1) -> {

        System.out.println("Received length and breadth... now calculating area");
        return number * number1;
    };

    public static void main(String[] args) throws ExecutionException, InterruptedException {



        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
                    System.out.println(" Getting length of rectangle "+Thread.currentThread().getName());
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return 4;
                })
                .thenCombine(CompletableFuture.supplyAsync(()-> {
                    System.out.println("getting breadth "+Thread.currentThread().getName());
                    return 2;
                }),(num1,num2) -> areaOfRectangle.apply(num1,num2));

        System.out.println(integerCompletableFuture.get()+" "+ Thread.currentThread().getName());
    }


}
