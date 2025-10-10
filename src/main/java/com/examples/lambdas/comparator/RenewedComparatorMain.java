package com.examples.lambdas.comparator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class RenewedComparatorMain {

    public static void main(String[] args) {

        PersonService personService = new PersonService();
        List<Person> persons = personService.initPersons();

        //comparing method
        Collections.sort(persons,comparing(Person::getName));
        System.out.println("Sorted using comparing method::");
        persons.forEach(System.out::println);

        // thenComparing method
        Collections.sort(persons, Comparator.comparing(Person::getName).thenComparing(Person::getAge));
        System.out.println("Sorted using thenComparing method::");
        persons.forEach(System.out::println);

        List<String> personNames = persons.stream().map(Person::getName).collect(Collectors.toCollection(ArrayList::new));
        // naturalOrder method
        Collections.sort(personNames,Comparator.naturalOrder());
        personNames.forEach(System.out::println);

        // reverseOrder method
        System.out.println("Sorting in reverse order::");
        Collections.sort(personNames,Comparator.reverseOrder());
        personNames.forEach(System.out::println);

        // nullsFirst method
        System.out.println("Nulls first");
        Collections.sort(personNames,Comparator.nullsFirst(Comparator.naturalOrder()));
        personNames.forEach(System.out::println);

        // nullsFirst method
        System.out.println("Nulls last");
        Collections.sort(personNames,Comparator.nullsLast(Comparator.naturalOrder()));
        personNames.forEach(System.out::println);

    }
}
