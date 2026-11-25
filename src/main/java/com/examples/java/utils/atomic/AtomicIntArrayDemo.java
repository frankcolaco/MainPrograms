package com.examples.java.utils.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntArrayDemo {

    public static void main(String[] args) {
        int[] inputArr = new int[]{11,33,55,23,10};

        AtomicIntegerArray aInputArr = new AtomicIntegerArray(inputArr);

        int index = 2;

        int item = aInputArr.get(index);
        System.out.println("Item at index 2: "+item);

        aInputArr.set(index,44);

        aInputArr.compareAndSet(index,44,41);
        System.out.println("Item set at index 2 after compare and set:: "+aInputArr.get(index));

        // returns the value and then adds passed-in arg
        int result = aInputArr.addAndGet(index,5);
        System.out.println("addAndGet:: "+result);

        result = aInputArr.getAndAdd(index,5);
        System.out.println("getAndAdd:: "+result);

        // getAndIncrement() - gets the value and then increments
        result = aInputArr.getAndIncrement(index);
        System.out.println("Item at index 2 after getAndIncrement() = " + result);

        // incrementAndGet() - increments and then returns the result
        result = aInputArr.incrementAndGet(index);
        System.out.println("Item at index 2 after incrementAndGet() = " + result);

        // decrementAndGet() - decrements and then gets the result
        result = aInputArr.decrementAndGet(index);
        System.out.println("Item at index 2 after decrementAndGet() = " + result);

        // getAndDecrement() -
        result = aInputArr.getAndDecrement(index);
        System.out.println("Item at index 2 after getAndDecrement() = " + result);
    }
}
