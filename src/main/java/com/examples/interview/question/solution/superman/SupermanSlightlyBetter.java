package com.examples.interview.question.solution.superman;

public class SupermanSlightlyBetter {

    private static SupermanSlightlyBetter superman;

    private SupermanSlightlyBetter() {
    }


    public static SupermanSlightlyBetter getInstance() {
        if (superman == null) {
            synchronized (SupermanSlightlyBetter.class) {
                if (superman == null) {
                    superman = new SupermanSlightlyBetter();
                }
            }
        }
        return superman;
    }

    public void fly() {
        System.out.println("I am superman and i can fly...");
    }
}
