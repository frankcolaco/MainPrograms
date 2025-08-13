package com.examples.function;

import java.util.function.BiFunction;

public class BiFunctionMain {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> addFunction = Integer::sum;

        System.out.println("Sum:  "+addFunction.apply(1, 2));
    }
}
