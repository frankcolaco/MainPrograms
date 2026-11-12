package com.examples.interview.question.solution.printing.fizzbuzz;

public class MultiThreadedFizzBuzz {

    private int n;
    private int num = 1;

    public MultiThreadedFizzBuzz(int n) {
        this.n = n;
    }

    public synchronized void fizz() throws InterruptedException {
        while (num <= n) {
            if (num % 3 == 0 && num % 5 != 0) {
                System.out.println("FIZZ");
                num++;
                notifyAll();
            } else wait();
        }
    }

    public synchronized void buzz() throws InterruptedException {
        while (num <= n) {
            if (num % 3 != 0 && num % 5 == 0) {
                System.out.println("BUZZ");
                num++;
                notifyAll();
            } else wait();
        }
    }

    public synchronized void fizzBuzz() throws InterruptedException {
        while (num <= n) {
            if (num % 15 == 0) {
                System.out.println("FIZZBUZZ");
                num++;
                notifyAll();
            } else wait();
        }
    }

    public synchronized void number() throws InterruptedException {
        while (num <= n) {
            if (num % 3 != 0 && num % 5 != 0) {
                System.out.println(num);
                num++;
                notifyAll();
            } else wait();
        }
    }
}
