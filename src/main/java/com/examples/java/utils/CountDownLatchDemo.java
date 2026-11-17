package com.examples.java.utils;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(2);
        Worker workerA = new Worker(countDownLatch,"A");
        Worker workerB = new Worker(countDownLatch,"B");

        workerA.start();
        workerB.start();

        countDownLatch.await();

        Master master = new Master("Master");
        master.start();


    }
}

class Worker extends Thread{

    private final CountDownLatch countDownLatch;

    public Worker(CountDownLatch countDownLatch,String name){
        super(name);
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        System.out.println("Worker "+ Thread.currentThread().getName()+ " started");
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
        System.out.println("Worker "+Thread.currentThread().getName()+" finished");

        countDownLatch.countDown();

    }
}

class Master extends Thread{

    public Master(String name){
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Master executed "+Thread.currentThread().getName());

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        System.out.println("Master finished");
    }
}
