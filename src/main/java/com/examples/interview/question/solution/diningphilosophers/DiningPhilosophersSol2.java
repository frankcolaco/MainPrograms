package com.examples.interview.question.solution.diningphilosophers;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class DiningPhilosophersSol2 {

    private static Random random = new Random(System.currentTimeMillis());

    private Semaphore[] forks = new Semaphore[5];

    public DiningPhilosophersSol2() {
        forks[0] = new Semaphore(1);
        forks[1] = new Semaphore(1);
        forks[2] = new Semaphore(1);
        forks[3] = new Semaphore(1);
        forks[4] = new Semaphore(1);
    }

    public void lifecycleOfPhilosopher(int id) throws InterruptedException {

        while (true) {
            contemplate();
            eat(id);
        }
    }

    void contemplate() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+ " is contemplating");
        Thread.sleep(random.nextInt(500));
    }

    void eat(int id) throws InterruptedException {

        // we randomly selected one of the philosopher to be left-handed. all others ust be right-handed
        // to avoid deadlock.

        if(id == 3){
            acquireForkLeftHanded(3);
        }else{
            acquireForkRightHanded(id);
        }

        System.out.println("Philosopher "+ id + " is eating");
        forks[id].release();
        forks[(id+1)%5].release();
    }

    private void acquireForkRightHanded(int id) throws InterruptedException {

        forks[id].acquire(); // acquire right fork
        forks[(id+1)%5].acquire();
    }

    private void acquireForkLeftHanded(int id) throws InterruptedException {
        forks[(id+1)%5].acquire(); //acquire left fork
        forks[id].acquire();
    }
}
