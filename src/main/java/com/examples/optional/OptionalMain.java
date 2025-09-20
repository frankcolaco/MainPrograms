package com.examples.optional;

import com.examples.pojo.Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalMain {

    Map<Integer, Employee> empMap = new HashMap<>();

    public void populateEmployee() {
        empMap.put(123, new Employee(123, "John Doe", 25, "male", "Engineering", 2015, 75000));
    }

    public Optional<Employee> getEmployee(Integer employeeId) {
        // Before returning the employee object we are wrapping it into an Optional
        return Optional.ofNullable(empMap.get(employeeId));
    }

    public static void main(String[] args) {

        OptionalMain optMain = new OptionalMain();
        optMain.populateEmployee();
        // isPresent Example
        Optional<Employee> employeeOpt = optMain.getEmployee(123);
        if (employeeOpt.isPresent()) {
            System.out.println("Employee found: " + employeeOpt.get());
        } else {
            System.out.println("Employee not found");
        }

        //ifPresent example
        Optional<Employee> employeeOpt2 = optMain.getEmployee(456);
        employeeOpt2.ifPresent(employee -> System.out.println("Employee found: " + employee));

        // get example
        Optional<Employee> employeeOpt3 = optMain.getEmployee(123);
        try {
            Employee employee = employeeOpt3.get();
            System.out.println("Employee found using get: " + employee);
        } catch (Exception e) {
            System.out.println("Employee not found using get");
        }

        // orElse example
        Optional<String> optional = Optional.ofNullable(null);
        System.out.println("Value or default: " + optional.orElse("Default Value"));
    }
}
