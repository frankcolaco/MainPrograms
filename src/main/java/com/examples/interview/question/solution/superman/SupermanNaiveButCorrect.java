package com.examples.interview.question.solution.superman;

public class SupermanNaiveButCorrect {

    private SupermanNaiveButCorrect() {
    }

    private static SupermanNaiveButCorrect superman = new SupermanNaiveButCorrect();

    public static SupermanNaiveButCorrect getInstance() {
        return superman;
    }

    public void fly() {
        System.out.println("I am superman and i can fly...");
    }
}
