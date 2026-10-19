package com.examples;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MissingNumbersMain {

    public static void main(String[] args) {
        int[] array = {2,3,3,3,5,7,8,9,1};
        SequencedSet<Integer> uniqueNumbers = Arrays.stream(array)
                .boxed()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));

        List<Integer> missingNumbers = IntStream.rangeClosed(uniqueNumbers.getFirst(),uniqueNumbers.getLast())
                .filter( i -> !uniqueNumbers.contains(i))
                .boxed().toList();

        System.out.println(missingNumbers);

    }
}
