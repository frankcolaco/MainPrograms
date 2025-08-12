package com.examples.predicates;

import com.examples.lambdas.comparator.Person;

import java.util.function.BiPredicate;

public class BiPredicateMain {

    static boolean isPersonEligibleForVoting(Person person,int age, BiPredicate<Person,Integer> predicate) {
        return predicate.test(person,age);
    }

    public static void main(String[] args) {

        Person person = new Person("Alex",23,"CA");
        boolean isEligible = isPersonEligibleForVoting(person,20,(p,minAge)->p.getAge() >= minAge);
        System.out.println("Person eligible for voting using BiPredicate "+isEligible);
    }
}
