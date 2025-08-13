package com.examples.streams;

import java.util.Arrays;
import java.util.List;

public class StreamsFlatMapDemo {

    public static void main(String[] args) {
        // Example of using flatMap with a stream of lists
        // This example assumes you have a list of lists and you want to flatten it into a single stream

         List<List<String>> listOfLists = Arrays.asList(Arrays.asList("a", "b","s"), Arrays.asList("c", "d"));
         listOfLists.stream().flatMap(List::stream).forEach(System.out::println);

        // Note: Uncomment the above lines and import necessary classes to run the example
    }
}
