package com.examples;
import javax.sound.midi.Soundbank;
import java.util.*;

public class ConcurrentModificationExceptionMain {


        public static void main(String[] args) {
            List<String> items = new ArrayList<>();
            items.add("Apple");
            items.add("Banana");
            items.add("Cherry");
           // items.add("Date");

            for (String item : items) {
                if (item.equals("Banana")) {
                    items.remove(item);
                }
            }

            SequencedSet<Integer> uniqueNumbers = new LinkedHashSet<>();
            List<Integer> uniqueNumberSet = new ArrayList<>();
            Map<String,Integer> empData = new HashMap<>();
            empData.put("Frank",25000);
            empData.put("Alisha",25000);
            empData.put("Frank",25001);/*Map.of(
                    "Frank",25000,
                    "Alisha",25000,
                    "Frank",25001

            );*/

            uniqueNumbers.add(10);
            boolean isAddedAgain = uniqueNumbers.add(10);
            uniqueNumbers.addFirst(3);
            uniqueNumberSet.addFirst(3);
            System.out.println("Was duplicate added? " + isAddedAgain);
            System.out.println("Set size: " + uniqueNumbers.size());
            System.out.println("let's check value of Frank: " + empData.get("Frank"));

        }
}
