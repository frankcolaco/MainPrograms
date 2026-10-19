package com.examples;

import java.util.Random;

public class RaceConditionDemo {

    public static void main(String[] args) throws InterruptedException {
        RaceCondition.runTest();
    }
}

class RaceCondition{

    int randInt;
    Random random = new Random(System.currentTimeMillis());

    void printer(){
        int i=10000;
        while(i!=0){
            if(randInt %5 ==0){
                System.out.println(randInt);
            }
            i--;
        }
    }

    void modifier(){
        int i=10000;
        while(i!=0){
            randInt = random.nextInt(1000);
            i--;
        }
    }

    public static void runTest() throws InterruptedException {
        final RaceCondition raceCondition = new RaceCondition();
        Thread t1 = new Thread(raceCondition::printer);
        Thread t2 = new Thread(raceCondition::modifier);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
