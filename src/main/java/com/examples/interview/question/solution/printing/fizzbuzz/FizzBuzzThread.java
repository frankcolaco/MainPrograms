package com.examples.interview.question.solution.printing.fizzbuzz;

public class FizzBuzzThread extends Thread {

    private MultiThreadedFizzBuzz multiThreadedFizzBuzz;
    private String method;

    public FizzBuzzThread(MultiThreadedFizzBuzz multiThreadedFizzBuzz, String method) {
        this.method = method;
        this.multiThreadedFizzBuzz = multiThreadedFizzBuzz;
    }

    @Override
    public void run() {
        if ("fizz".equals(method)) {
            try {
                multiThreadedFizzBuzz.fizz();
            } catch (InterruptedException e) {

            }
        } else if ("buzz".equals(method)) {
            try {
                multiThreadedFizzBuzz.buzz();
            } catch (InterruptedException e) {

            }
        } else if ("fizzBuzz".equals(method)) {
            try {
                multiThreadedFizzBuzz.fizzBuzz();
            } catch (InterruptedException e) {

            }
        } else if ("number".equals(method)) {
            try {
                multiThreadedFizzBuzz.number();
            } catch (InterruptedException e) {

            }
        }
    }
}
