package com.examples.interview.question.solution.fifolock;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

public class FifoLock {

    private ConcurrentLinkedQueue<Thread> queue = new ConcurrentLinkedQueue<>();
    private AtomicBoolean locked = new AtomicBoolean(false);

    public void lock(){
        // enqueue the current thread in the list of threads waiting to acquire the lock
        queue.add(Thread.currentThread());

        /*
        we will use compare and set method to change the status of the FIFOLock to locked.
        Also, if the thread wakes up from park call we check for the predicate, that is the lock
        available for acquiring and also whether the woken-up thread is at the head of the queue.
        Note:: park() method can experience spurious wake up.
         */
        while(queue.peek() != Thread.currentThread() ||
                !locked.compareAndSet(false,true)){
            LockSupport.park();
        }
        queue.remove();
    }

    public void lockWithBlocker(){
        // enqueue the current thread in the list of threads waiting to acquire the lock
        queue.add(Thread.currentThread());

        /*
        we will use compare and set method to change the status of the FIFOLock to locked.
        Also, if the thread wakes up from park call we check for the predicate, that is the lock
        available for acquiring and also whether the woken-up thread is at the head of the queue.
        Note:: park() method can experience spurious wake up.
         */
        while(queue.peek() != Thread.currentThread() ||
                !locked.compareAndSet(false,true)){
            // we just set blocker as this current object
            LockSupport.park(this);
        }
        queue.remove();
    }

    public void unlock(){

        //set the lock to false
        locked.set(false);

        //unpark the head of queue
        System.out.println("unlocking:: "+Thread.currentThread().getName());
        LockSupport.unpark(queue.peek());
    }
}
