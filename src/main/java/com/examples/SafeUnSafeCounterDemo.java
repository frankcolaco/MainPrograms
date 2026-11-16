package com.examples;

/**
 * this class demonstrates the safe and unsafe counter using threadlocal keyword
 */
public class SafeUnSafeCounterDemo {

    public static void main(String[] args) throws InterruptedException {
        UnsafeCounter usc = new UnsafeCounter();

        Thread[] tasks = new Thread[100];

        for(int i=0;i<100;i++){
            Thread t = new Thread(()->{
                for(int j=0;j<100;j++){
                    usc.increment();
                    usc.incrementCounter();
                }
            });
            tasks[i]=t;
            t.start();
        }

        for(Thread t : tasks){
            t.join();
        }

        System.out.println("Unsafe counter:: "+usc.count);
        System.out.println("Safe counter:: "+usc.counter.get());
    }
}

class UnsafeCounter {

    int count = 0;
    ThreadLocal<Integer> counter = ThreadLocal.withInitial(() -> 0);
    void increment(){
        count = count+1;
    }

    void incrementCounter(){
        counter.set(counter.get()+1);
    }



}
