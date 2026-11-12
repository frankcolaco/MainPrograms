package com.examples.interview.question.solution.printing.numberseries;

import java.util.concurrent.Semaphore;

/**
 * this class prints number series using only two threads and two semaphores
 */
public class PrintNumberSeries {

    private final int limit;
    private int current = 1;

    public PrintNumberSeries(int limit){
        this.limit=limit;
    }

    private Semaphore oddSem = new Semaphore(1);
    private Semaphore evenSem = new Semaphore(0);


    private void printOdd(){
        while(true){

            try {
                oddSem.acquire();
                if(current>limit){
                    evenSem.release();
                    break;
                }
                System.out.printf("odd %02d ",current);
                current++;
                evenSem.release();
            }catch (Exception e){}
        }
    }

    private void printEven(){
        while (true){
            try{
                evenSem.acquire();
                if(current>limit){
                    oddSem.release();
                    break;
                }

                System.out.printf("even %02d ",current);
                current++;
                oddSem.release();
            } catch (Exception e) {

            }
        }
    }

    public static void main(String[] args) {

        PrintNumberSeries printNumberSeries = new PrintNumberSeries(10);
        Thread t1 = new Thread(printNumberSeries::printOdd,"odd");
        Thread t2 = new Thread(printNumberSeries::printEven,"even");

        t2.start();
        t1.start();
    }
}
