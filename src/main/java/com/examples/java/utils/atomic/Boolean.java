package com.examples.java.utils.atomic;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class Boolean {

    static volatile boolean won = false;

    static AtomicBoolean aWon = new AtomicBoolean(false);

    public static void main(String args[]) throws Exception {

        ExecutorService es = Executors.newFixedThreadPool(25);
        try {
            int numThreads = 15;
            Runnable[] racers = new Runnable[numThreads];
            Future[] futures = new Future[numThreads];

            // create thread tasks
            for (int i = 0; i < numThreads; i++) {
                // race() is faulty and requires synchronization. simpler version is raceABoolean()
                //which uses AtomicBoolean variable
                // race();
                racers[i] = Boolean::raceABoolean;
            }

            // submit threads for execution
            for (int i = 0; i < numThreads; i++) {
                futures[i] = es.submit(racers[i]);
            }

            // wait for threads to finish
            for (int i = 0; i < numThreads; i++) {
                futures[i].get();
            }
        } finally {
            es.shutdown();
        }
    }

    static void race() {
        if (!won) {
            won = true;
            System.out.println(Thread.currentThread().getName() + " won the race.");
        } else {
            System.out.println(Thread.currentThread().getName() + " lost.");
        }
    }

    static void raceABoolean(){
        if(aWon.compareAndSet(false,true)){
            System.out.println(Thread.currentThread().getName()+" won the race.");
        }else {
            System.out.println(Thread.currentThread().getName()+ " lost.");
        }
    }
}


