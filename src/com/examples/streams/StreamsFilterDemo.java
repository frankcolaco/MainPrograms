package com.examples.streams;

import com.examples.lambdas.comparator.Person;

import java.util.Arrays;
import java.util.List;

public class StreamsFilterDemo {

    public static void main(String[] args) {
        // filter example with Integer object
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        intList.stream().filter(integer -> integer >=5).forEach(integer -> System.out.println("integers greater than or equal to 5 "+integer));

        intList.forEach(System.out::println);

        // filter example with Custom object

        List<Person> personList = Arrays.asList(new Person("John", 25,"CA"),
                new Person("Jane", 30,"NY"),
                new Person("Jack", 35,"TX"),
                new Person("Jill", 40,"FL"));
        // persons with age between 25 and 30
        personList.stream().filter(person -> person.getAge() >= 25 && person.getAge() <= 30)
                .forEach(person -> System.out.println("Person with age between 25 and 30: " + person.getName()));

        // filter chaining
        personList.stream().filter(person -> person.getAge() >= 35)
                .filter(person -> person.getAge() <= 40).forEach(person -> System.out.println("Person with age between 35 and 40 using filter chaining: " + person.getName()));
    }
}
