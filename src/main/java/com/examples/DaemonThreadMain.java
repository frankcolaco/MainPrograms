package com.examples;

public class DaemonThreadMain {

    public static void main(String[] args) {

        Thread innerThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("I am a new thread!" + i);
            }
        });
        innerThread.setDaemon(true);
        innerThread.start();
        System.out.println("Main thread exiting");

    }
}
