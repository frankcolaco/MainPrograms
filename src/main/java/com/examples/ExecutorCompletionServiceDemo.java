package com.examples;

import com.examples.interview.question.solution.asynctosync.Executor;

import java.util.Random;
import java.util.concurrent.*;

public class ExecutorCompletionServiceDemo {

    static Random random = new Random(System.currentTimeMillis());


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        completionServiceExample();
    }

    static void completionServiceExample() throws ExecutionException, InterruptedException {

        class TrivialTask implements Runnable {
            int n;

            public TrivialTask(int n) {
                this.n = n;
            }

            @Override
            public void run() {

                try {
                    Thread.sleep(random.nextInt(101));
                } catch (InterruptedException e) {

                }
            }
        }
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        ExecutorCompletionService<Integer> service = new ExecutorCompletionService<>(threadPool);

        for(int i=0;i<10;i++){
            service.submit(new TrivialTask(i),i);
        }

        int count =10;
        while(count!=0){
            Future<Integer> f = service.poll();
            if(f!=null){
                System.out.println("Thread "+f.get()+ " got done.");
                count--;
            }
        }
        threadPool.shutdown();
    }
}
