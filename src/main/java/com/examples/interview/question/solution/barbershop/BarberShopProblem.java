package com.examples.interview.question.solution.barbershop;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class BarberShopProblem {

    final int chairs = 3;

    int waitingCustomers = 0;
    ReentrantLock lock = new ReentrantLock();

    Semaphore waitForCustomerToEnter = new Semaphore(0);
    Semaphore waitForBarberToGetReady = new Semaphore(0);
    Semaphore waitForCustomerToLeave = new Semaphore(0);
    Semaphore waitForBarberToCutHair = new Semaphore(0);

    int hairCutsGiven = 0;

    void customerWalksIn() throws InterruptedException {

        lock.lock();
        if (waitingCustomers == chairs) {
            System.out.println("Customer walks out, all chairs are occupied");
            lock.unlock();
            return;
        }
        waitingCustomers++;
        lock.unlock();

        // let barber know that there is atleast 1 customer
        waitForCustomerToEnter.release();

        // wait for barber to call you to sit on chair
        waitForBarberToGetReady.acquire();

        // wait for haircut to complete
        waitForBarberToCutHair.acquire();
        // leave the barber chair and let barber thread know chair is vacant.
        waitForCustomerToLeave.release();

        lock.lock();
        waitingCustomers--;
        lock.unlock();


    }

    void barber() throws InterruptedException {
        while (true) {
            // wait till a customer enters a shop
            waitForCustomerToEnter.acquire();
            // let customer know barber is ready
            waitForBarberToGetReady.release();
            hairCutsGiven++;
            System.out.println("Barber cutting hair... " + hairCutsGiven);
            Thread.sleep(50);

            // let customer thread know haircut is done.
            waitForBarberToCutHair.release();
            // wait for customer to leave barber chair.
            waitForCustomerToLeave.acquire();
        }
    }
}
