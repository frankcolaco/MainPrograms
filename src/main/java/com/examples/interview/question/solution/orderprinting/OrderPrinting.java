package com.examples.interview.question.solution.orderprinting;

public class OrderPrinting {

    private int count;

    public OrderPrinting(){
        count=1;
    }

    public void printFirst(){

        synchronized (this){
            System.out.println("First");
            count++;
            notifyAll();
        }
    }

    public void printSecond() throws InterruptedException {

        synchronized (this){
            while(count !=2){
                wait();
            }
            System.out.println("Second");
            count++;
            notifyAll();
        }
    }

    public void printThird() throws InterruptedException {

        synchronized (this){
            while(count!=3){
                wait();
            }

            System.out.println("Third");
            notifyAll();
        }
    }
}
