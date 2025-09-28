package com.examples.collectors;

import com.examples.streams.Employee;
import com.examples.streams.RecordsMain;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsAggregatorOpsMain {

    public static void main(String[] args) {
        List<Employee> employees = RecordsMain.initEmployees();

        // using counting method to count.
        long count = employees.stream().filter(emp -> emp.age() <30).collect(Collectors.counting());
        System.out.println("employees count below age of 30 using counting():: "+count);

        long countOfEmp = employees.stream().filter(emp -> emp.age() < 30).count();
        System.out.println("employees count below age of 30 using count:: "+countOfEmp);

        //using summingDouble() to get sum of salaries of all employees
        double sumOfSalaries = employees.stream().collect(Collectors.summingDouble(emp -> emp.salary()));
        System.out.println("Sum of salaries using summingDouble: "+sumOfSalaries);

        double sumOfSalariesOfEmp = employees.stream().mapToDouble(Employee::salary).sum();
        System.out.println("Sum of salaries using mapToDouble: "+sumOfSalariesOfEmp);

        // using averagingDouble() to get the average salaries of all employees
        double avgOfSalaries = employees.stream().collect(Collectors.averagingDouble(Employee::salary));
        System.out.println("Avg. salaries of employees using averagingDouble:: "+avgOfSalaries);

        // using minBy() method get employee with min salary
        Optional<Employee> empWithMinSalary = employees.stream().collect(Collectors.minBy(Comparator.comparing(Employee::salary)));
        System.out.println("employee with minimum salary using minBy():: "+ ((empWithMinSalary.isPresent())? empWithMinSalary.get().name():"none"));
        Optional<Employee> emplWithMinSalary = employees.stream().min(Comparator.comparing(Employee::salary));
        System.out.println("employee with minimum salary using min:: "+ ((emplWithMinSalary.isPresent())? emplWithMinSalary.get().name():"none"));

        // using maxBy() method get employee with max salary
        Optional<Employee> empWithMaxSalary = employees.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::salary)));
        System.out.println("Employee with max salary using maxBy():: "+((empWithMaxSalary.isPresent())? empWithMaxSalary.get().name():"none"));

        // using max() method get employee with max salary
        Optional<Employee> emplWithMaxSalary =  employees.stream().max(Comparator.comparing(Employee::salary));
        System.out.println("Employee with max salary using max():: "+((emplWithMaxSalary.isPresent())? emplWithMaxSalary.get().name():"none"));

        // summarizingInt()
        System.out.println(employees.stream().collect(Collectors.summarizingDouble(Employee::salary)));

        // joining method on String

        String joinedStr = Stream.of("how","are","you").collect(Collectors.joining());
        System.out.println(joinedStr);

        joinedStr = Stream.of("how","are","you").collect(Collectors.joining(" "));
        System.out.println(joinedStr);

        joinedStr = Stream.of("how","are","you").collect(Collectors.joining(","));
        System.out.println(joinedStr);

        joinedStr = Stream.of("how","are","you").collect(Collectors.joining(", "," P "," S"));
        System.out.println(joinedStr);
    }
}
