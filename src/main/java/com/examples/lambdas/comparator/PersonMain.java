package com.examples.lambdas.comparator;

import java.util.ArrayList;
import java.util.List;

public class PersonMain {

    public static void main(String[] args) {
        PersonService personService = new PersonService();
        List<Person> persons = personService.initPersons();

        List<Person> sortedPersons = PersonService.getPersons(persons);
        System.out.println("Persons after sorting");
        // Printing the name of each person.
        for(Person person : sortedPersons){
            System.out.println("Person Name : " + person.getName());
        }

    }
}
