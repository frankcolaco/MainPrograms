package com.examples.java.utils.locks.reentrant;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService service = Executors.newFixedThreadPool(5);
        ReentrantLock lock = new ReentrantLock();

        Runnable tA = () -> threadA(lock);

        Runnable tB = () -> threadB(lock);

        try{

            lock.lock();
            lock.lock();
            lock.lock();

            System.out.println("Main thread lock hold count:: "+lock.getHoldCount());

            Future f1 = service.submit(tA);
            Future f2 = service.submit(tB);

            for(int i=0;i<3;i++){
                Thread.sleep(50);
                lock.unlock();
            }

            System.out.println("Main thread released the lock. Lock hold count:: "+lock.getHoldCount());
            f1.get();
            f2.get();

        }finally {
            for(int i=0;i< lock.getHoldCount();i++){
                lock.unlock();
            }
            service.shutdown();
        }
    }

    private static void threadA(ReentrantLock lock) {
        String name = "THREAD-A";
        Thread.currentThread().setName(name);
        boolean keepTrying = true;

        System.out.println("is lock owned by other thread:: "+lock.isLocked());

        while(keepTrying){
            System.out.println(name+ " trying to acquire lock");

            if(lock.tryLock()){
                try {
                    System.out.println(name + " acquired lock");
                    keepTrying = false;
                }finally {
                    lock.unlock();
                    System.out.println(name + " released lock");
                }
            }else{
                System.out.println(name+ " failed to acquire lock. other threads waiting = "+lock.getQueueLength());
            }

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {

            }
        }
    }

    private static void threadB(Lock lock) {
        lock.lock();
        lock.unlock();
    }
}
