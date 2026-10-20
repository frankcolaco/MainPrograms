package com.examples.interview.question.solution.tokenbucket;

import java.util.HashSet;
import java.util.Set;

public class MultiThreadedTokenBucketFilterDemo {

    private final int MAX_TOKENS;
    private long possibleTokens = 0;

    public MultiThreadedTokenBucketFilterDemo(int maxTokens){
        this.MAX_TOKENS=maxTokens;
        Thread dt = new Thread(this::daemonThread);
        dt.setDaemon(true);
        dt.start();
    }

    private void daemonThread(){
        while(true){
            synchronized (this){
                if(possibleTokens < MAX_TOKENS){
                    possibleTokens++;
                }
                this.notify();
            }
            try{
                int ONE_SECOND = 1000;
                Thread.sleep(ONE_SECOND);
            }catch (InterruptedException e){
                System.out.println("we have a problem");
            }
        }
    }

    void getToken() throws InterruptedException{

        synchronized (this){
            while(possibleTokens == 0) {
                this.wait();
            }
            possibleTokens--;
            System.out.println("Granting "+Thread.currentThread().getName() + " token at "+(System.currentTimeMillis()/1000));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Set<Thread> threads = new HashSet<>();
        final MultiThreadedTokenBucketFilterDemo multiThreadedTokenBucketFilterDemo = new MultiThreadedTokenBucketFilterDemo(3);
        Thread.sleep(1000);
        for (int i = 0; i < 10; i++) {

            Thread thread = new Thread(()-> {

                    try {
                        multiThreadedTokenBucketFilterDemo.getToken();
                    } catch (InterruptedException ie) {
                        System.out.println("We have a problem");
                    }
            });
            thread.setName("Thread_" + (i + 1));
            threads.add(thread);
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }
    }
}
