package com.examples.collectors;

import com.examples.streams.Employee;
import com.examples.streams.RecordsMain;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemoMain {

    public static void main(String[] args) {
        List<Employee> employees = RecordsMain.initEmployees();

        // collecting employees in list
        List<String> empNames = employees.stream().map(Employee::name).toList();
        System.out.println("Employee Names:: "+empNames);

        // collecting employees in set
        Set<String> departments = employees.stream().map(Employee::department).collect(Collectors.toSet());
        System.out.println("Departments:: "+ departments);

        //toCollection example where we will collect employees in LinkedList
        LinkedList<String> empNamesInLinkedList = employees.stream().map(Employee::name).collect(Collectors.toCollection(LinkedList::new));
        System.out.println("Employee names in LinkedList:: "+empNamesInLinkedList);

        //toMap example where we will collect Employees with their Id's
        Map<Integer,String> employeeMap = new HashMap<>();
        //employeeMap = employees.stream().collect(Collectors.toMap(Employee::id, Employee::name));
        System.out.println("Employee map using collect method:: "+employeeMap);

        //toMap overloaded method to handle exception in case of duplicates
        employeeMap = employees.stream().collect(Collectors.toMap(Employee::id,Employee::name,(emp1,emp2)-> emp1));
        System.out.println("Employee map using collect method and handling duplicates:: "+employeeMap);

        //collectingAndThen example where we will collect elements in list and then convert to unmodifiable list
        List<String> unmodifiableEmployees =  employees.stream().map(Employee::name).collect(Collectors.collectingAndThen(Collectors.toList(),Collections::unmodifiableList));
        System.out.println("Unmodifiable employees:: "+ unmodifiableEmployees);
    }
}
