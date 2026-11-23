package com.examples.java.utils.locks.stamped;

import java.util.concurrent.locks.StampedLock;

public class OptimisticReadStampedLockDemo {

    static StampedLock stampedLock = new StampedLock();

    public static void main(String[] args) {

        int[] array = new int[3];
        array[0]=3;
        array[1]=5;
        array[2]=7;

        System.out.println("product of three:: "+productOfThree(array));
    }

    static int productOfThree(int[] array){

        long oReadStamp = stampedLock.tryOptimisticRead();

        int num1 = array[0];
        int num2= array[1];
        int num3 = array[2];

        // if stamp isn't valid anymore i.e. write lock was acquired then get the read lock

        if(!stampedLock.validate(oReadStamp)){
            oReadStamp = stampedLock.readLock();

            try{
                // we used values from array and not the local variables num1,2,3
                // because if the validation fails we should fallback to using original values and not the cached ones.
                return array[0]*array[1]*array[2];
            } catch (RuntimeException e) {
                throw e;
            }finally {
                stampedLock.unlockRead(oReadStamp);
            }
        }
        return num1*num2*num3;
    }
}
