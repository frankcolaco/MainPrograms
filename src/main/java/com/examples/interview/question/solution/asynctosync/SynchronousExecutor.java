package com.examples.interview.question.solution.asynctosync;

/**
 *
 * The overridden method internally calls the parent's (async) method but before that we create signal
 * object for notification and waiting purpose.
 * We need to pass the signal object to the superclass's asynchronized execution method so that the
 * asynchronous execution thread can notify the signal variable once asynchronous execution is complete.
 * We pass in the callback object super class's method. We can wrap the original callback in another callback
 * object and pass also our signal variable to super class.
 */
public class SynchronousExecutor extends Executor{
    @Override
    public void asynchronousExecution(Callback callback) throws Exception {

        Object signal = new Object();
        final boolean[] isDone = new boolean[1];

        Callback cb = () -> {
            System.out.println("inside cb");
            callback.done();
            System.out.println("cb done called");
            // signal object getting passed to parent class
            synchronized (signal){
                signal.notify();
                isDone[0]=true;
            }
        };

        super.asynchronousExecution(cb);

        synchronized (signal){
            while(!isDone[0]){
                signal.wait();
            }
        }
    }
}
