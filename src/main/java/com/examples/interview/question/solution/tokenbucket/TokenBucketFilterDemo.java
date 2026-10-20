package com.examples.interview.question.solution.tokenbucket;

import java.util.HashSet;
import java.util.Set;

public class TokenBucketFilterDemo {

    private final int MAX_TOKENS;
    private long lastRequestTime = System.currentTimeMillis();
    long possibleTokens = 0;

    TokenBucketFilterDemo(int maxTokens){
        this.MAX_TOKENS = maxTokens;
    }

    synchronized void getToken() throws InterruptedException{
        possibleTokens += (System.currentTimeMillis() - lastRequestTime) /1000;

        if(possibleTokens > MAX_TOKENS){
            possibleTokens = MAX_TOKENS;
        }

        if(possibleTokens == 0){
            Thread.sleep(1000);
        }else{
            possibleTokens--;
        }
        lastRequestTime = System.currentTimeMillis();

        System.out.println("Granting "+ Thread.currentThread().getName()+ " token at "+ (System.currentTimeMillis()/1000));
    }

    public static void runTestMaxTokenIs1() throws InterruptedException {
        Set<Thread> threads = new HashSet<>();
        final TokenBucketFilterDemo tokenBucket = new TokenBucketFilterDemo(3);

        Thread.sleep(10000);
        for(int i=0;i<10;i++){
            Thread thread =  new Thread(()->{
                try{
                    tokenBucket.getToken();
                }catch (InterruptedException e){
                    System.out.println("we have a problem");
                }
            });
            thread.setName("Thread_" +(i+1));
            threads.add(thread);
        }

        for(Thread t: threads){
            t.start();
        }
        for (Thread t: threads){
            t.join();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TokenBucketFilterDemo.runTestMaxTokenIs1();
    }
}
