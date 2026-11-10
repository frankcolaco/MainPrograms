package com.examples.interview.question.solution.print.synchronously;

public class PrintSynchronously {

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(3);
        FooBarThread t1 = new FooBarThread(fooBar,"foo");
        FooBarThread t2 = new FooBarThread(fooBar,"bar");

        t2.start();
        t1.start();
    }
}
