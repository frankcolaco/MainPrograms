package com.examples.interview.question.solution.superman;

public class SupermanWithFlaws {

    private static SupermanWithFlaws superman;

    private SupermanWithFlaws() {
    }

    // This will fail with multiple threads
    public static SupermanWithFlaws getInstance() {
        if (superman == null) {

            /*
            a thread can be context switched at this point and superman will
            evaluate to null for any other threads testing the if condition. now multiple
            threads will fall into this if clause till superman object is assigned a value.
            All these threads will initialize the superman object when it should have been initialized
            only once.
             */
            superman = new SupermanWithFlaws();
        }
        return superman;
    }

    public void fly() {
        System.out.println("I am superman and i can fly...");
    }
}
