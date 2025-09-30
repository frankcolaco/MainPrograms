package com.examples.collectors;

import com.examples.streams.Employee;
import com.examples.streams.RecordsMain;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class CollectorsGroupingOpsMain {

    public static void main(String[] args) {

        List<Employee> employees = RecordsMain.initEmployees();

        //employees grouped by department using groupingBy()
        Map<String,List<Employee>> employeesByDepartment = employees.stream().collect(Collectors.groupingBy(Employee::department));
        System.out.println("employees by department:: "+employeesByDepartment);

        //employees grouped by department using groupingBy() but specifying collector in which the result should be stored
        Map<String, Set<Employee>> uniqueEmployeesByDepartment = employees.stream().collect(Collectors.groupingBy(Employee::department,Collectors.toSet()));
        System.out.println("employees by department in a set:: "+uniqueEmployeesByDepartment);

        // employees grouped by department and age
        Map<String,Map<Integer,List<Employee>>> employeesByDeptByAge = employees.stream().collect(Collectors.groupingBy(Employee::department,Collectors.groupingBy(Employee::age)));
        System.out.println("employees by department and then by age:: "+employeesByDeptByAge);

        // salary by department
        Map<String,Double> salariesByDept = employees.stream().collect(Collectors.groupingBy(Employee::department,Collectors.summingDouble(Employee::salary)));
        System.out.println("salaries by department:: "+salariesByDept);

        // employee by max salary in department
        Map<String, Optional<Employee>> employeeEarningHighest = employees.stream().collect(Collectors.groupingBy(Employee::department,Collectors.maxBy(Comparator.comparingDouble(Employee::salary))));
        System.out.println("employee with max salary in Department:: "+employeeEarningHighest);

        // grouping by method has one overloaded method which helps us specify which Map implementation to be used
        Map<String,Set<Employee>> employeeMap = employees.stream().collect(Collectors.groupingBy(Employee::department,HashMap::new,Collectors.toSet()));
        System.out.println("employees in map:: "+employeeMap);

        // we can also get result in concurrent hashmap
        ConcurrentMap<String,List<Employee>> employeeConcurrentMap = employees.stream().collect(Collectors.groupingByConcurrent(Employee::department));
        System.out.println("employees in concurrent map:: "+employeeConcurrentMap);

        // partitioningBy() provides true and false results of our predicate
        Map<Boolean,List<Employee>> employeesPartitionedMap = employees.stream().collect(Collectors.partitioningBy(emp ->emp.age()>25));
        System.out.println("partition by result:: "+employeesPartitionedMap);
    }
}
