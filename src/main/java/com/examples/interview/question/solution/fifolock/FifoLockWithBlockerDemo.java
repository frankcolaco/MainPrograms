package com.examples.interview.question.solution.fifolock;

import java.util.concurrent.locks.LockSupport;

public class FifoLockWithBlockerDemo {

    public static void main(String[] args) throws InterruptedException {

        FifoLock fifoLock = new FifoLock();

        /*
        main thread locks the Fifolock instance so that the spawned thread parks itself when
        invoking lock()
         */
        fifoLock.lockWithBlocker();

        Thread t = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+ " about to park itself");
            fifoLock.lockWithBlocker();
        });

        t.start();

        Thread.sleep(2000);

        // retrieving the blocker
        Object object = LockSupport.getBlocker(t);

        System.out.println(object);

        fifoLock.unlock();
    }
}
