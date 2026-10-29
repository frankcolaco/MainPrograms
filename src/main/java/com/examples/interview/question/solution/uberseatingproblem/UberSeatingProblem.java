package com.examples.interview.question.solution.uberseatingproblem;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class UberSeatingProblem {

    private int republicans = 0;
    private int democrats = 0;

    CyclicBarrier barrier = new CyclicBarrier(4);
    ReentrantLock lock = new ReentrantLock();

    Semaphore demsWaiting = new Semaphore(0);
    Semaphore repubsWaiting = new Semaphore(0);

    void seatDemocrat() throws InterruptedException, BrokenBarrierException {

        boolean rideLeader = false;
        lock.lock();

        democrats++;

        if (democrats == 4) {
            // seat all democrats in the uber ride
            demsWaiting.release(3);
            democrats -= 4;
            rideLeader = true;
        } else if (democrats == 2 && republicans >= 2) {
            //seat 2 republicans and 2 democrats
            demsWaiting.release(1);
            repubsWaiting.release(2);

            rideLeader = true;
            democrats -= 2;
            republicans -= 2;
        } else {
            lock.unlock();
            demsWaiting.acquire();
        }
        seated();
        barrier.await();

        if (rideLeader) {
            drive();
            lock.unlock();
        }
    }

    void seatRepublican() throws InterruptedException, BrokenBarrierException {

        boolean rideLeader = false;
        lock.lock();
        republicans++;
        if (republicans == 4) {
            // seat all republicans
            repubsWaiting.release(3);
            republicans -= 4;
            rideLeader = true;
        } else if (republicans == 2 && democrats >= 2) {
            // seat 2 repubs and 2 democrats
            demsWaiting.release(2);
            repubsWaiting.release(1);
            democrats -= 2;
            republicans -= 2;

            rideLeader = true;

        } else {
            lock.unlock();
            repubsWaiting.acquire();
        }
        seated();
        barrier.await();
        if (rideLeader) {
            drive();
            lock.unlock();
        }
    }

    private void seated() {

        System.out.println(Thread.currentThread().getName() + " seated.");
        System.out.flush();
    }

    private void drive() {

        System.out.println("Uber ride on Its way... with ride leader "+Thread.currentThread().getName());
        System.out.flush();
    }
}
