package com.examples.java.utils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CyclicBarrierDemo {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, ()-> System.out.println("All parties have reached the barrier, let's continue execution"));

        Thread task1 = new Thread(new Task(cyclicBarrier),"T1");
        Thread task2 = new Thread(new Task(cyclicBarrier),"T2");
        Thread task3 = new Thread(new Task(cyclicBarrier),"T3");

        task1.start();
        task2.start();
        task3.start();

    }
}

class Task implements Runnable{

    private final CyclicBarrier cyclicBarrier;

    public Task(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier=cyclicBarrier;
    }

    @Override
    public void run() {

        try{
            System.out.println(Thread.currentThread().getName()+ " is waiting on barrier");
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName()+ " has crossed the barrier");
        } catch (BrokenBarrierException | InterruptedException e) {
            Logger.getLogger(Task.class.getName()).log(Level.SEVERE,null,e);
        }

    }
}
