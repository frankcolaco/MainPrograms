package com.examples.interview.question.solution.uberseatingproblem;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;

public class UberSeatingProblemDemo {

    public static void main(String[] args) throws InterruptedException {

        UberSeatingProblem uberSeatingProblem = new UberSeatingProblem();
        Set<Thread> threads = new HashSet<>();

        for(int i=0;i<10;i++){
            Thread t = new Thread(()->{

                try{
                    uberSeatingProblem.seatDemocrat();
                } catch (InterruptedException e) {
                    System.out.println("interrupted problem");
                } catch (BrokenBarrierException e) {
                    System.out.println("barrier problem");
                }
            });
            t.setName("Democrat_"+ (i+1));
            threads.add(t);
            Thread.sleep(40);
        }

        for(int i=0;i<10;i++){
            Thread t = new Thread(()->{

                try{
                    uberSeatingProblem.seatRepublican();
                } catch (InterruptedException e) {
                    System.out.println("interrupted problem");
                } catch (BrokenBarrierException e) {
                    System.out.println("barrier problem");
                }
            });
            t.setName("Republican_"+ (i+1));
            threads.add(t);
            Thread.sleep(20);
        }

        for(Thread t: threads) t.start();

        for(Thread t: threads) t.join();
    }
}
