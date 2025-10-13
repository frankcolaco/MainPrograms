package com.examples.locks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

public class StampedLockNonBlockingMain {

    /*
    in async calls Stamp lock has below methods
        1. tryReadLock(): acquire lock if it is available immediately otherwise don't lock
        2. tryWriteLock(): acquire lock if is available immediately otherwise don't lock
        3. tryReadLock(long time, TimeUnit unit): try to acquire lock till the provided time limit.
        4. tryWriteLock(long time,TimeUnit unit): try to acquire lock till the provided time limit.

    In StampedLock class we can convert lock from one mode to another i.e. we can convert read lock to write lock and vise versa

        methods that help achieve this as follows:
        1. tryConvertToWriteLock(long stamp)
        2. tryConvertToReadLock(long stamp)
        3. tryConvertToOptimisticRead(long stamp)

        1. tryConvertToWriteLock(long stamp):
                - if the lock we are trying to convert is already a write lock then return the lock
                - if the lock we are trying to convert is a read lock and a write lock is available then return the write lock and release read lock.
                - if the lock we are trying to convert is an optimist read lock, then return the write lock if available.
                - return zero.

        2. tryConvertToReadLock(long stamp):
                - if the lock we are trying to convert is already a read lock then return the lock
                - if the lock we are trying to convert is a write lock and a read lock is available then return the read lock and release write lock.
                - if the lock we are trying to convert is an optimist read lock, then return the read lock if available.
                - return zero.

        3. tryConvertToOptimistRead(long stamp):
                - if stamp represents an optimist read lock, then return if it is validated
                - if the stamp represents a lock then release the lock and return observation stamp.
                - return zero.
     */

    static Map<String,Integer> data = new HashMap<>();
    static StampedLock lock = new StampedLock();

    public static Integer readDataFromMap(String key){
        long stamp = lock.tryReadLock();
        int result = 0;
        if(stamp != 0L){
            try{
                result =  data.get(key);
            }finally{
                lock.unlockRead(stamp);
            }
        }
        return result;
    }

    public static Integer readDataFromMapOptimistically(String key){
        long stamp = lock.tryOptimisticRead();
        int result = 0;
        if(stamp != 0L){
                result =  data.get(key);
            }

        if(!lock.validate(stamp)){
            System.out.println("validation failed");
        }
        return result;
    }

    public static void writeDataToMap(String key,Integer value){
        long stamp = lock.tryWriteLock();
        if(stamp !=0){
            try{
                data.put(key,value);
            }finally {
                lock.unlockWrite(stamp);
            }
        }
    }

    public static void main(String[] args) {

        writeDataToMap("kings",232);
        Integer value = readDataFromMap("kings");
        Integer oValue = readDataFromMapOptimistically("kings");
        System.out.println(value);
        System.out.println("optimist value:: "+oValue);

    }
}
