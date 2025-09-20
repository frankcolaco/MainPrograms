package com.examples.streams;

import java.util.List;

public class StreamsMapDemo {

    public static void main(String[] args) {
        // Example of using map with a stream
        // Assuming we have a list of integers and we want to square each number
        java.util.List<Integer> numbers = java.util.Arrays.asList(1, 2, 3, 4, 5);

        // Using map to square each number
        java.util.List<Integer> squaredNumbers = numbers.stream()
                .map(n -> n * n)
                .toList();

        // Printing the squared numbers
        System.out.println("Squared Numbers: " + squaredNumbers);

        // Example of using map with a stream to convert strings to uppercase
        List<String> names = List.of("Alice", "Bob", "Charlie");
        names.stream().map(String::toUpperCase).forEach(System.out::println);

        // example of mapToInt
        names.stream().mapToInt(String::length).forEach(System.out::println);
    }
}
