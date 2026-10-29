package com.examples.interview.question.solution.diningphilosophers;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class DiningPhilosophers {

    // random numbers is used for test purpose
    private static Random random = new Random(System.currentTimeMillis());

    // five semaphores represent five forks
    private Semaphore[] forks = new Semaphore[5];
    private Semaphore maxDinners = new Semaphore(4);

    public DiningPhilosophers(){
        forks[0]=new Semaphore(1);
        forks[1]= new Semaphore(1);
        forks[2] = new Semaphore(1);
        forks[3] = new Semaphore(1);
        forks[4] = new Semaphore(1);
    }

    //represents philosophers life

    public void lifeCycleOfPhilosopher(int id) throws InterruptedException{

        while(true){
            contemplate();
            eats(id);
        }
    }

    //we can sleep the thread when it contemplates
    private void contemplate() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+ " is contemplating");
        Thread.sleep(random.nextInt(500));
    }

    // this will be the meat of our solution where the philosopher will eat
    private void eats(int id) throws InterruptedException{

        // maxDinners only allows 4 philosophers to attempt picking up forks.
        maxDinners.acquire();
        forks[id].acquire();

        forks[(id+4) % 5].acquire();

        System.out.println("Philosopher "+id + " is eating");

        forks[id].release();
        forks[(id+4)%5].release();
        maxDinners.release();
    }
}
