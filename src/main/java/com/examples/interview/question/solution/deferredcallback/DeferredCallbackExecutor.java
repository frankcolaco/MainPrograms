package com.examples.interview.question.solution.deferredcallback;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DeferredCallbackExecutor {

    PriorityQueue<CallBack> pQueue = new PriorityQueue<>((c1, c2)-> (int)(c1.executeAt - c2.executeAt));

    ReentrantLock rLock =  new ReentrantLock();
    Condition newCallBackArrived = rLock.newCondition();

    public void start() throws InterruptedException{
        long sleepFor;
        while(true){
            // lock critical section
            rLock.lock();

            // if no item in the queue, wait indefinitely for one to arrive
            while(pQueue.isEmpty()){
                System.out.println("waiting as it is empty");
                newCallBackArrived.await();
            }

            // loop till all callbacks are executed
            while(!pQueue.isEmpty()){

                //  find the min time execution thread should sleep for before next callback becomes due
                sleepFor = findSleepDuration();

                // if callback is due break from loop and start executing the callback
                if(sleepFor<=0){
                    break;
                }

                // sleep until the earliest due callback can be executed
                newCallBackArrived.await(sleepFor, TimeUnit.MILLISECONDS);

            }

            // as we have a min-heap the first element of the queue would be the one which is due
            CallBack callBack = pQueue.poll();
            assert callBack != null;
            System.out.println("Executed at "+System.currentTimeMillis()/1000 + " required at "+ callBack.executeAt/1000 + " message: "+callBack.message);
            //never forget to unlock.
            rLock.unlock();
        }
    }

    private long findSleepDuration(){
        long currentTime = System.currentTimeMillis();
        assert pQueue.peek() != null;
        return pQueue.peek().executeAt - currentTime;
    }

    public void registerCallback(CallBack callBack){
        rLock.lock();
        pQueue.add(callBack);
        newCallBackArrived.signal();
        rLock.unlock();

    }

    /**
     * Represents the class which holds the callback. For simplicity instead of
     * executing a method, we print a message.
     */
    static class CallBack{
        long executeAt;
        String message;

        public CallBack(long executeAfter,String message){
            this.executeAt=System.currentTimeMillis() + executeAfter * 1000;
            this.message=message;
        }
    }

    public static void runTestCallBacks() throws InterruptedException {
        Set<Thread> threads = new HashSet<>();
        DeferredCallbackExecutor deferredCallbackExecutor = new DeferredCallbackExecutor();

        Thread service = new Thread(() ->{
            try {
                deferredCallbackExecutor.start();
            } catch (InterruptedException e) {
                System.out.println();
            }
        });
        service.start();
        Random random = new Random();
        for(int i = 0; i< 10;i++){
            Thread cbThreads = new Thread(()->{
                CallBack callBack = new CallBack(random.nextInt(1,11),"Hello this is "+Thread.currentThread().getName());
                deferredCallbackExecutor.registerCallback(callBack);
            });
            cbThreads.setName("Thread_"+(i+1));
            cbThreads.start();
            threads.add(cbThreads);
            Thread.sleep(1000);
        }

        for(Thread t:threads)
            t.join();
    }
}
