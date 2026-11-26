package com.examples.java.utils.atomic;

import java.util.concurrent.atomic.AtomicLongArray;

public class AtomicLongArrayDemo {

    public static void main(String[] args) {
        long[] lArr = new long[]{11,16,19,10,4};
        AtomicLongArray aLongArr = new AtomicLongArray(lArr);

        int index = 3;

        //get op
        long result = aLongArr.get(index);
        System.out.println("Item at index 3 "+result);

        // set operation
        aLongArr.set(index, 37);
        System.out.println("Item now at index 3 = " + aLongArr.get(3));

        // compare and set operation.
        aLongArr.compareAndSet(index, 37, 41);
        System.out.println("Item at index 3 after compareAndSet operation = " + aLongArr.get(index));

        // addAndGet() - adds the passed-in argument and returns the result
        result = aLongArr.addAndGet(index, 5);
        System.out.println("Item at index 3 after addAndGet(5) = " + result);

        // getAndAdd() - returns the value, and then adds the passed-in argument
        result = aLongArr.getAndAdd(index, 5);
        System.out.println("Item at index 3 after addAndGet(5) = " + result);

        // getAndIncrement() - gets the value and then increments
        result = aLongArr.getAndIncrement(index);
        System.out.println("Item at index 3 after getAndIncrement() = " + result);

        // incrementAndGet() - increments and then returns the result
        result = aLongArr.incrementAndGet(index);
        System.out.println("Item at index 3 after incrementAndGet() = " + result);

        // decrementAndGet() - decrements and then gets the result
        result = aLongArr.decrementAndGet(index);
        System.out.println("Item at index 3 after decrementAndGet() = " + result);

        // getAndDecrement() -
        result = aLongArr.getAndDecrement(index);
        System.out.println("Item at index 3 after getAndDecrement() = " + result);
    }
}
