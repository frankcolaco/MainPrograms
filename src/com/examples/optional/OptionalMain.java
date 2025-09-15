package com.examples.optional;

import com.examples.pojo.Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalMain {

    Map<Integer, Employee> empMap = new HashMap<>();

    public void populateEmployee() {
        empMap.put(123, new Employee(123, "John Doe", 25, "male", "Engineering", 2015, 75000));
        empMap.put(124, new Employee(124, "Mary Doe", 25, "female", "Engineering", 2013, 50000));
    }

    public Optional<Employee> getEmployee(Integer employeeId) {
        // Before returning the employee object we are wrapping it into an Optional
        return Optional.ofNullable(empMap.get(employeeId));
    }

    public Optional<Map<Integer, Employee>> getEmpMap() {
        return Optional.ofNullable(empMap);
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
            Employee employee = employeeOpt3.isPresent() ? employeeOpt3.get() : null;
            System.out.println("Employee found using get: " + employee);
        } catch (Exception e) {
            System.out.println("Employee not found using get");
        }

        // orElse example
        Optional<String> optional = Optional.ofNullable(null);
        System.out.println("Value or default: " + optional.orElse("Default Value"));

        // orElseGet example
        // This will return the default value.
        System.out.println(optional.orElseGet(OptionalMain::getDefaultValue));

        // orElseThrow example
        try {
            System.out.println("Value or exception: " + optional.orElseThrow(() -> new Exception("No value present")));
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // optional filter()
        Optional<String> fruits = Optional.ofNullable("orange");
        // Since the filter condition is matched, this will return the optional.
        System.out.println("returning when condition matched:: "+fruits.filter(str -> str.equals("orange")));

        // Since the filter condition is not matched, this will return empty optional.
        System.out.println("returning when condition mismatched:: "+fruits.filter(str -> str.equals("apple")));

        // optional with map method
        Optional<Employee> oEmployee = Optional.of(new Employee(124, "Mary Doe", 25, "female", "Engineering", 2013, 50000));
        oEmployee.map(employee -> employee.salary())
                .filter(salary -> salary > 25000)
                .ifPresentOrElse(salary -> System.out.println("Employee found "), () -> System.out.println("Employee not found"));
    }

    public static String getDefaultValue(){
        return "default";
    }
}
