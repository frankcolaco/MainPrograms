package com.examples.interview.question.solution.asynctosync;

public class Executor {

    public void asynchronousExecution(Callback callback) throws Exception{
        Thread t = new Thread(()->{
            try {
                // do something
                System.out.println("inside async thread");
                Thread.sleep(5000);
                System.out.println("do something done...");
            } catch (InterruptedException e) {

            }
            callback.done();
        });
        t.start();
    }
}
