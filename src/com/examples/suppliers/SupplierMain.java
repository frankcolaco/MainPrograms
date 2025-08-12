package com.examples.suppliers;

import com.examples.lambdas.comparator.Person;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SupplierMain {

    static boolean isPersonEligibleForVoting(Supplier<Person>supplier, Predicate<Person> predicate) {
        return predicate.test(supplier.get());
    }
    public static void main(String[] args) {
        Supplier<Person> supplier = () -> new Person("Alex",23,"CA");
        Predicate<Person> predicate = person -> person.getAge() >= 18;

        System.out.println("Person is eligible for voting "+ isPersonEligibleForVoting(supplier, predicate));

        IntSupplier intSupplier = () -> 23;
        System.out.println(intSupplier.getAsInt());

        DoubleSupplier doubleSupplier = () -> (int)(Math.random()*100);
        System.out.println(doubleSupplier.getAsDouble());

    }
}
