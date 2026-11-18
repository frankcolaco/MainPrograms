package com.examples.java.utils;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.ensureCapacity(500000);

        CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>(arrayList);

        //calculating the time it takes to add a number in copyOnWrite arrayList

        long startTime = System.nanoTime();
        numbers.add(500001);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);

        //calculating the time it takes to add a number in regular arrayList

        long startTime_al = System.nanoTime();
        arrayList.add(500001);
        long endTime_al = System.nanoTime();
        long duration_al = (endTime_al - startTime_al);

        System.out.println("Time taken by a regular arrayList:: "+duration_al+ " in nano seconds");
        System.out.println("Time taken by a CopyOnWrite arraylist:: "+duration+" in nano seconds");


    }

}
