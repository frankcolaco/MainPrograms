package com.examples.lambdas;

import com.examples.streams.Employee;
import com.examples.streams.RecordsMain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CollectionsMain {

    public static void main(String[] args) {

        List<Employee> employees = RecordsMain.initEmployees();
        Iterator<Employee> iterator = employees.iterator();
        // conventional iteration of list

        while(iterator.hasNext()){
            System.out.println("using while loop:: "+iterator.next());
        }
        iterator = employees.iterator();
        // improvement in java8 is the use of forEachRemaining()
        iterator.forEachRemaining((emp) -> System.out.println("using forEachRemaining:: "+emp));


        //Map improvements::
        /*
         * if Map has no key, and we try to get the value from Map it will throw NPE
         * In order to avoid NPE we will have a condition to check if key is present and only then retrieve the value.
         * With java 8 we do not require the condition to check if key is present, instead use getOrDefault().
         * Below is the example
         */

        Map<String , Integer> fruits = new HashMap<>();
        fruits.put("apple", 20);
        System.out.println("Map before adding new entry");
        System.out.println(fruits);
        System.out.println("Map after adding new entry");
        fruits.put("banana",fruits.getOrDefault("banana",0)+20);
        System.out.println(fruits);

        /*
         * with java 8, we have flexibility to only add entry in Map if the key is not present by using putIfAbsent
         */
        System.out.println("Map before entry of putIfAbsent():: "+fruits);
        fruits.putIfAbsent("banana",30);
        fruits.putIfAbsent("pineapple",10);
        System.out.println("Map after entry of putIfAbsent():: "+fruits); // here it will keep previously added banana entry and not override it but add pineapple entry as it was not present

        /*
         * Java 8 has other methods which help us manage Map efficiently and effectively, some methods are compute(), computeIfAbsent() and computeIfPresent().
         */

        /*compute() method computes a new mapping given the key and its existing value.
        This method returns the computed value. If the key is not present in the map, then an exception is thrown.

         */

        int fruitPrice = fruits.compute("pineapple",(k,v)-> v+5);
        System.out.println("fruit price:: "+fruitPrice);

        /*
            computeIfAbsent() method returns:

            The original value if the key is already present in the map.
            The computed value if the key is not present in the map and also inserts the details in map.

         */

        fruitPrice = fruits.computeIfAbsent("apple",v-> 10);
        System.out.println("already present key's value:: "+fruitPrice);

        fruitPrice = fruits.computeIfAbsent("dragon",v->10);
        System.out.println("new entry's price:: "+fruitPrice);
        System.out.println("new map:: "+fruits);

        /*
        The computeIfPresent() method returns:

            A null value if the key is not present in the map.
            The computed value if the key is present in the map.

         */

        fruitPrice = fruits.computeIfPresent("dragon",(k,v)-> v+12);
        System.out.println(fruitPrice);

        fruitPrice = fruits.computeIfPresent("mango",(k,v)->v+1);
        System.out.println(fruitPrice); // throws NPE

    }
}
