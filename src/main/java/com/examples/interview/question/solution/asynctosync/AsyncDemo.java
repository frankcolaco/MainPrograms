package com.examples.interview.question.solution.asynctosync;

public class AsyncDemo {

    public static void main(String[] args) throws Exception {
        Executor executor = new Executor();
        executor.asynchronousExecution(()-> System.out.println("I am done"));

        System.out.println("main thread is exiting...");
    }
}
