package com.examples.interview.question.solution.asynctosync;

/**
 * Executor is an async class which does work and then exits.
 * But when we run the program the main thread exits first before the async task is complete.
 * By not modifying the program make the main thread wait until the async task is complete.
 *
 * Solution:
 *
 *      In order to make is synchronous without touching the existing code,
 *      we will create a new Executor which extends Executor and try to make it synchronous.
 *      go to Asynchronous class for more details.
 */
public class AsyncToSyncDemo {

    public static void main(String[] args) throws Exception {
        SynchronousExecutor synchronousExecutor = new SynchronousExecutor();
        synchronousExecutor.asynchronousExecution(()-> System.out.println("I am done"));

        System.out.println("main thread is exiting...");
    }
}
