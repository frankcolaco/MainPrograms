package com.examples.interview.question.solution.printing.fizzbuzz;

public class MultiThreadedFizzBuzzDemo {

    public static void main(String[] args) {
        MultiThreadedFizzBuzz multiThreadedFizzBuzz = new MultiThreadedFizzBuzz(16);

        FizzBuzzThread t1 = new FizzBuzzThread(multiThreadedFizzBuzz,"fizz");
        FizzBuzzThread t2 = new FizzBuzzThread(multiThreadedFizzBuzz,"buzz");
        FizzBuzzThread t3 = new FizzBuzzThread(multiThreadedFizzBuzz,"fizzBuzz");
        FizzBuzzThread t4 = new FizzBuzzThread(multiThreadedFizzBuzz,"number");

        t2.start();
        t1.start();t3.start();t4.start();
    }
}
