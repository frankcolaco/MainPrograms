package com.examples.streams;
import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class SecondHighestMain {

    public static void main(String[] args) {
        List<Employee> employees = RecordsMain.initEmployees();
        System.out.println("Second highest salary:: "+ Objects.requireNonNull(findSecondHighestSalary(employees)));

        System.out.println("Alternate approach for second highest salary: "+Objects.requireNonNull(findSecondHighestSalaryAlternate(employees)));
    }

    private static Optional<Double> findSecondHighestSalaryAlternate(List<Employee> employees) {

        if(CollectionUtils.isEmpty(employees) || employees.size()<2){
            return Optional.empty();
        }

        return employees.stream()
                .map(Employee::salary)
                .reduce((first,second)->second)
                .flatMap(last -> employees.stream().map(Employee::salary).distinct().sorted(Comparator.reverseOrder())
                        .skip(1)
                        .findFirst());
    }

    private static Optional<Double> findSecondHighestSalary(List<Employee> employees) {

        if(CollectionUtils.isEmpty(employees) || employees.size()<2){
            return Optional.empty();
        }

        return employees.stream()
                .map(Employee::salary)// extracts only the salary double values from objects. this reduces data early
                .distinct()//removes duplicates. critical when multiple employees earn same salary
                .sorted(Comparator.reverseOrder()) // sorts in descending order. Internally, this is stateful intermediate operation.
                .skip(1) // discards first (highest) element, moving the window to second.
                .findFirst(); // terminal option that returns an Optional with second highest.
    }

}
