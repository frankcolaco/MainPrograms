package com.examples.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class RecordsMain {
    /**
     * 1 Count of Male & Female employees
     * 2 List of All Departments
     * 3 Average Age grouped by Gender
     * 4 Highest Paid employee 💰
     * 5 Employees who joined after 2015
     * 6 Count of employees per Department
     * 7 Average Salary per Department
     * 8 Youngest Male in Development 👨‍💻
     * 9 Most Experienced Employee
     * 10 Gender-wise count in Sales Team
     * 11 Average & Total Salary (with teeing)
     * 12 Partition by Age: ≤25 and >25
     * 13 The Oldest Employee
     * @param args
     */
    public static void main(String[] args) {

       // 1 Count of Male & Female employees
        Map<String, Long>employeesByGender = initEmployees().stream()
                .collect(
                        java.util.stream.Collectors.groupingBy(Employee::gender, Collectors.counting()));
        System.out.println("Count of Male and Female employees: " + employeesByGender);

        // 2 List of All Departments
        List<String> departments = initEmployees().stream()
                .map(Employee::department)
                .distinct()
                .toList();
        System.out.println("List of All Departments: " + departments);

        //3 Average Age grouped by Gender
        Map<String, Double> averageAgeByGender = initEmployees().stream()
                .collect(Collectors.groupingBy(Employee::gender, Collectors.averagingInt(Employee::age)));
        System.out.println("Average age by gender" + averageAgeByGender);

        // 4 Highest Paid employee
        Employee highestPaidEmployee = initEmployees().stream()
                .max(Comparator.comparingDouble(Employee::salary))
                .orElse(null);

        if (highestPaidEmployee !=null) {
            System.out.println("Highest Paid Employee: "  +highestPaidEmployee );
        } else {
            System.out.println("No employees found");
        }

        // 5 Employees who joined after 2015
        List<Employee> employeesAfter2015 = initEmployees().stream()
                .filter(employee -> employee.yearOfJoining() > 2015)
                .toList();
        System.out.println("Employees who joined after 2015: " + employeesAfter2015);

        // 6 Count of employees per Department
        Map<String, Long> employeesCountByDepartment = initEmployees().stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.counting()));
        System.out.println("Count of employees per Department: " + employeesCountByDepartment);

        // 7 Average Salary per Department
        Map<String, Double> averageSalaryByDepartment = initEmployees().stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.averagingDouble(Employee::salary)));
        System.out.println("Average Salary per Department: " + averageSalaryByDepartment);

        // 8 Youngest Male in Development
        Optional<Employee> youngestMaleInDevelopment = initEmployees().stream()
                .filter(employee -> employee.gender().equalsIgnoreCase("Male") && employee.department().equalsIgnoreCase("Engineering"))
                .min(Comparator.comparingInt(Employee::age));
        youngestMaleInDevelopment.ifPresent(employee -> System.out.println("Youngest male in Development: " + employee));

        // 9 Most Experienced Employee
        Employee mostExperiencedEmployee = initEmployees().stream()
                .min(Comparator.comparingInt(Employee::yearOfJoining))
                .orElse(null);
        if (mostExperiencedEmployee != null) {
            System.out.println("Most Experienced Employee: " + mostExperiencedEmployee);
        } else {
            System.out.println("No employees found");
        }

        // 10 Gender-wise count in Sales Team
        Map<String, Long> genderCountInSales = initEmployees().stream()
                .filter(employee -> employee.department().equalsIgnoreCase("Sales"))
                .collect(Collectors.groupingBy(Employee::gender, Collectors.counting()));
        System.out.println("Gender Count in sales: "+ genderCountInSales);

        // 11 Average & Total Salary (with teeing)
            String averageAndTotalSalary = initEmployees().stream()
                .collect(Collectors.teeing(
                        Collectors.averagingDouble(Employee::salary),
                        Collectors.summingDouble(Employee::salary),
                        (avg, total) -> String.format("Average Salary: %.2f, Total Salary: %.2f", avg, total)
                ));
        System.out.println("Average & Total Salary: " + averageAndTotalSalary);
        // 12 Partition by Age: ≤25 and >25
        Map<Boolean, List<Employee>> partitionedByAge = initEmployees().stream()
                .collect(Collectors.partitioningBy(employee -> employee.age() <= 25));
        System.out.println("Employees aged 25 or less: " + partitionedByAge.get(true));
        System.out.println("Employees aged 25 or more: " + partitionedByAge.get(false));
        // 13 The Oldest Employee
            Employee oldestEmployee = initEmployees().stream()
                .max(Comparator.comparingInt(Employee::age))
                .orElse(null);
        if (oldestEmployee != null) {
            System.out.println("Oldest Employee: " + oldestEmployee);
        } else {
            System.out.println("No employees found");
        }
    }

    public static List<Employee> initEmployees() {
        return List.of(
                new Employee(1, "John Doe", 25, "Male", "Engineering", 2020, 60000.0),
                new Employee(2, "Jane Smith", 30, "Female", "Marketing", 2018, 65000.0),
                new Employee(3, "Alice Johnson", 28, "Female", "Finance", 2019, 70000.0),
                new Employee(4, "Bob Brown", 35, "Male", "Engineering", 2015, 80000.0),
                new Employee(5, "Carol White", 32, "Female", "HR", 2017, 62000.0),
                new Employee(6, "David Black", 29, "Male", "Sales", 2021, 55000.0),
                new Employee(7, "Eve Green", 27, "Female", "Engineering", 2022, 61000.0),
                new Employee(8, "Frank Blue", 31, "Male", "Finance", 2016, 72000.0),
                new Employee(9, "Grace Red", 26, "Female", "Marketing", 2020, 59000.0),
                new Employee(10, "Hank Yellow", 34, "Male", "HR", 2014, 81000.0),
                new Employee(11, "Ivy Purple", 33, "Female", "Sales", 2018, 67000.0),
                new Employee(12, "Jack Orange", 24, "Male", "Engineering", 2023, 53000.0),
                new Employee(13, "Kathy Pink", 29, "Female", "Finance", 2019, 70000.0),
                new Employee(14, "Leo Gray", 36, "Male", "Marketing", 2013, 85000.0),
                new Employee(15, "Mona Cyan", 28, "Female", "HR", 2021, 60000.0),
                new Employee(16, "Ned Silver", 31, "Male", "Sales", 2017, 69000.0),
                new Employee(17, "Olive Gold", 27, "Female", "Engineering", 2022, 62000.0),
                new Employee(18, "Paul Bronze", 32, "Male", "Finance", 2015, 75000.0),
                new Employee(19, "Quinn Teal", 25, "Female", "Marketing", 2020, 58000.0),
                new Employee(20, "Rita Lime", 34, "Female", "HR", 2016, 80000.0),
                new Employee(21, "Sam Navy", 30, "Male", "Sales", 2018, 66000.0),
                new Employee(22, "Tina Magenta", 28, "Female", "Engineering", 2021, 61000.0),
        new Employee(22, "Tina Magentai", 28, "Female", "Engineering", 2021, 61000.0));
    }
}
