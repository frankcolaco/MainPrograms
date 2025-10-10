package com.examples.lambdas.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonService {

    public static List<Person> getPersons(List<Person> persons){
        // Created an anonymous Comparator, which sorts the Person object on the basis of Person name.
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });

        Collections.sort(persons,(p1,p2)->p1.getName().compareTo(p2.getName()));
        return persons;
    }

    public List<Person> initPersons(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John" , 23 , "USA"));
        persons.add(new Person("Carl" , 25 , "Australia"));
        persons.add(new Person("Amit" , 28 , "India"));
        persons.add(new Person("Vikram" , 23 , "Bhutan"));
        persons.add(new Person("Kane" , 32 , "Brazil"));
        persons.add(new Person("Kane" , 31 , "USA"));

        return persons;
    }
}
