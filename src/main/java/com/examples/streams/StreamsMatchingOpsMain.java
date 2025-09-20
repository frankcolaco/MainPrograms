package com.examples.streams;

import java.util.ArrayList;
import java.util.List;

import com.examples.lambdas.comparator.Person;

public class StreamsMatchingOpsMain {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Dave", 23,"India"));
        list.add(new Person("Joe", 18,"USA"));
        list.add(new Person("Ryan", 54,"Canada"));
        list.add(new Person("Iyan", 5,"India"));
        list.add(new Person("Ray", 63,"China"));


        boolean anyIndian = list.stream().anyMatch(person -> person.getCountry().equals("India"));
        System.out.println("Is any person from India? " + anyIndian);

        boolean allAbove18 =  list.stream().allMatch(person -> person.getAge() > 18);
        System.out.println("Are all persons above 18? " + allAbove18);

        boolean noneFromUK = list.stream().noneMatch(person -> person.getCountry().equals("UK"));
        System.out.println("Is no person from UK? " + noneFromUK);

    }
}