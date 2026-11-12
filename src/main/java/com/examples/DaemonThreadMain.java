package com.examples;

/**
 * we created a simple daemon thread which does not print "I am a new Thread!" as main thread exits and daemon thread is killed.
 * In order to make sure thread is run, we need to use join method right after starting the thread.
 */
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
