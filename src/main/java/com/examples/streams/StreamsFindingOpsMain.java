package com.examples.streams;

import com.examples.lambdas.comparator.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StreamsFindingOpsMain {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Dave", 23,"India"));
        personList.add(new Person("Joe", 18,"USA"));
        personList.add(new Person("Ryan", 54,"Canada"));
        personList.add(new Person("Iyan", 5,"India"));
        personList.add(new Person("Ray", 63,"China"));
        personList.add(new Person("Raymond", 54,"China"));

        // findFirst
        Optional<Person> firstPerson =  personList.stream().filter(person -> person.getCountry().equals("India")).findFirst();
        firstPerson.ifPresent(person -> System.out.println("First person in the list who is from India:: " + person));

        //findAny

        Optional<Person> anyPerson = personList.stream().filter(person -> person.getCountry().equals("China")).findAny();
        anyPerson.ifPresent(person -> System.out.println("Person in china:: "+ anyPerson));


    }
}
