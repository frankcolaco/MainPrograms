package com.examples.interview.question.solution.tokenbucket.factory;

import java.util.HashSet;
import java.util.Set;

public class TokenBucketMultiThreadedFactoryDemo {

    public static void main(String[] args) throws InterruptedException {
        Set<Thread> threads = new HashSet<>();
        TokenBucketFilter tokenBucketFilter = TokenBucketFilterFactory.makeTokenBucketFilter(3);

        for (int i=0;i<20;i++){
            Thread thread = new Thread(()->{

                try {
                    tokenBucketFilter.getToken();
                } catch (InterruptedException e) {
                    System.out.println("we have a prob");
                }
            });
            thread.setName("Thread_ "+(i+1));
            threads.add(thread);

        }
        for(Thread t : threads)
            t.start();


        for (Thread t: threads)
            t.join();

    }
}
