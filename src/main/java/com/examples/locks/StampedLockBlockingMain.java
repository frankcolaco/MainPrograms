package com.examples.locks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

public class StampedLockBlockingMain {


     /*
        StampedLock has three modes:
            1. Read
            2. Write
            3. Optimistic read
         */

    public static void main(String[] args) {

        writeDataToMap("king",1);
        Integer value = readDataFromMap("king");
        System.out.println(value);

    }

    static Map<String,Integer> data = new HashMap<>();
    static StampedLock lock = new StampedLock();

    public static Integer readDataFromMap(String key){
        long stamp = lock.readLock();
        try{
            return data.get(key);
        }finally{
            lock.unlockRead(stamp);
        }
    }

    public static void writeDataToMap(String key,Integer value){
        long stamp = lock.writeLock();
        try{
            data.put(key,value);
        }finally {
            lock.unlockWrite(stamp);
        }
    }
}
