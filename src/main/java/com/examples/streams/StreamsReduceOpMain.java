package com.examples.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamsReduceOpMain {

    public static void main(String[] args) {

        List<Employee> employees = RecordsMain.initEmployees();

        Optional<Double> totalSalary = employees.stream()
                .map(Employee::salary)
                .reduce(Double::sum);

        totalSalary.ifPresent(aDouble -> System.out.println("Total salary in org:: " + aDouble));

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        int totalSum = list.stream().reduce(5, Integer::sum);
        System.out.println("Total sum using identity:: "+totalSum);

        int totalSumParallelStream = list.parallelStream().reduce(0, Integer::sum,Integer::sum);
        System.out.println("Total sum using parallel Stream:: "+totalSumParallelStream);

        System.out.println("Max number in list: "+list.stream().max(Comparator.naturalOrder()));
        System.out.println("Min number in list: "+list.stream().min(Comparator.naturalOrder()));

    }
}
