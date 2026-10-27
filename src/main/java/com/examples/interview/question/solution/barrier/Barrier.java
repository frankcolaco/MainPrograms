package com.examples.interview.question.solution.barrier;

public class Barrier {

    int count = 0;
    int totalThreads;
    int released = 0;

    public Barrier(int totalThreads) {
        this.totalThreads = totalThreads;
    }

    public synchronized void await() throws InterruptedException {
        // block any new threads from proceeding till all threads from previous barrier are released
        while (count == totalThreads) wait();

        // increment the thread whenever a thread arrives at barrier
        count++;

        if (count == totalThreads) {
            // wake up all threads
            notifyAll();
            released = totalThreads;
        } else {
            while (count < totalThreads) {
                wait();
            }
        }

        released--;
        if (released == 0) {
            count = 0;
            // this is to wake up threads waiting at line 15
            notifyAll();
        }
    }
}
