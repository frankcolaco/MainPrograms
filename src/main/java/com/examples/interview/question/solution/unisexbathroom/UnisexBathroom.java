package com.examples.interview.question.solution.unisexbathroom;

import java.util.concurrent.Semaphore;

public class UnisexBathroom {

    static final String WOMEN = "women";
    static final String MEN = "men";
    static final String NONE = "none";

    String inUseBy = "none";
    int empsInBathroom = 0;
    Semaphore maxEmps = new Semaphore(3);

    void useBathroom(String name) throws InterruptedException {
        System.out.println(name + " using bathroom. Current employees in bathroom = "+empsInBathroom);
        Thread.sleep(10000);
        System.out.println(name + " done using bathroom." );
    }

    void maleUseBathroom(String name) throws InterruptedException{
        synchronized (this){
            while(WOMEN.equals(inUseBy)){
                this.wait();
            }

            empsInBathroom++;
            inUseBy=MEN;
        }
        maxEmps.acquire();
        useBathroom(name);
        maxEmps.release();
        synchronized (this){
            empsInBathroom--;
            if(empsInBathroom==0) inUseBy=NONE;
            this.notifyAll();
        }
    }

    void femaleUseBathroom(String name) throws InterruptedException{

        synchronized (this){
            while(MEN.equals(inUseBy)){
                this.wait();
            }

            empsInBathroom++;
            inUseBy=WOMEN;
        }
        maxEmps.acquire();
        useBathroom(name);
        maxEmps.release();
        synchronized (this){
            empsInBathroom--;
            if(empsInBathroom==0) inUseBy=NONE;
            this.notifyAll();
        }
    }

}
