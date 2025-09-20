package com.examples.function;

import java.util.function.Function;

public class FunctionMain {

    public static void main(String[] args) {
        Function<String, Integer> lengthFunction = str -> str.length();

        System.out.println("Length of the string 'Hello World' is: " + lengthFunction.apply("Hello World"));

        Function<Integer,Integer> increment = i -> i + 1;
        Function<Integer,Integer> multiply = i -> i * 2;

        System.out.println("compose result: " + increment.compose(multiply).apply(5)); // this will first multiply and then increment

        System.out.println("andthen result:"+ increment.andThen(multiply).apply(5)); // this will first increment and then multiply
    }
}
