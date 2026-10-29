package com.examples.interview.question.solution.diningphilosophers;

import java.util.HashSet;
import java.util.Set;

public class DiningPhilosophersDemo2 {

    public static void main(String[] args) throws InterruptedException {
        final DiningPhilosophersSol2 diningPhilosophers = new DiningPhilosophersSol2();
        Set<Thread> philosophers = new HashSet<>();
        Thread p1 = new Thread(() -> {
            try {
                startPhilosopher(diningPhilosophers, 0);
            } catch (InterruptedException e) {
                System.out.println("problem ");
            }
        }, "Philosopher_0");
        philosophers.add(p1);

        Thread p2 = new Thread(() -> {
            try {
                startPhilosopher(diningPhilosophers, 1);
            } catch (InterruptedException e) {
                System.out.println("problem ");
            }
        }, "Philosopher_1");
        philosophers.add(p2);

        Thread p3 = new Thread(() -> {
            try {
                startPhilosopher(diningPhilosophers, 2);
            } catch (InterruptedException e) {
                System.out.println("problem ");
            }
        }, "Philosopher_2");

        philosophers.add(p3);

        Thread p4 = new Thread(() -> {
            try {
                startPhilosopher(diningPhilosophers, 3);
            } catch (InterruptedException e) {
                System.out.println("problem ");
            }
        }, "Philosopher_3");

        philosophers.add(p4);

        Thread p5 = new Thread(() -> {
            try {
                startPhilosopher(diningPhilosophers, 4);
            } catch (InterruptedException e) {
                System.out.println("problem ");
            }
        }, "Philosopher_4");
        philosophers.add(p5);

        for (Thread t : philosophers) {
            t.start();

        }
        for (Thread t : philosophers) {
            t.join();
        }

    }

    private static void startPhilosopher(DiningPhilosophersSol2 dp, int id) throws InterruptedException {
        dp.lifecycleOfPhilosopher(id);
    }

}
