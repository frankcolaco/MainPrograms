package com.examples.binary;

import java.util.function.BinaryOperator;

public class BinaryOpMain {

    public static void main(String[] args) {
        // Binary operator example
        BinaryOperator<Integer> add = (a, b) -> a + b;

        // Applying the binary operator
        int result = add.apply(5, 10);

        // Printing the result
        System.out.println("The sum of 5 and 10 is: " + result);
    }
}
