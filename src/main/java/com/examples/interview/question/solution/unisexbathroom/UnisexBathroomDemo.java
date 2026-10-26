package com.examples.interview.question.solution.unisexbathroom;

public class UnisexBathroomDemo {

    public static void main(String[] args) throws InterruptedException {
        UnisexBathroom unisexBathroom = new UnisexBathroom();

        Thread female1 = new Thread(()->{
            try {
                unisexBathroom.femaleUseBathroom("Lisa");
            } catch (InterruptedException e) {
            }
        });

        Thread male1 = new Thread(()->{
            try {
                unisexBathroom.maleUseBathroom("John");
            } catch (InterruptedException e) {
            }
        });

        Thread male2 = new Thread(()->{
            try {
                unisexBathroom.maleUseBathroom("Jacob");
            } catch (InterruptedException e) {
            }
        });

        Thread male3 = new Thread(()->{
            try {
                unisexBathroom.maleUseBathroom("Paul");
            } catch (InterruptedException e) {
            }
        });
        Thread male4 = new Thread(()->{
            try {
                unisexBathroom.maleUseBathroom("Ivan");
            } catch (InterruptedException e) {
            }
        });

        female1.start();
        male1.start();
        male2.start();
        male3.start();
        male4.start();

        female1.join();
        male1.join();
        male2.join();
        male3.join();
        male4.join();

    }
}
