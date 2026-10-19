package com.examples;


public class Main {

    private volatile boolean running = true;

    public void stop() {
        running = false;
    }

    public void runWork() {
        while(running){
            System.out.println("running");
        }
        System.out.println("completed");
    }
}