package com.examples.unary;

import java.util.function.UnaryOperator;

public class UnaryOpMain {

    public static void main(String[] args) {
        // Unary operator example
        UnaryOperator<Integer> square = x -> x * x;

        // Applying the unary operator
        int result = square.apply(5);

        // Printing the result
        System.out.println("The square of 5 is: " + result);
    }
}
