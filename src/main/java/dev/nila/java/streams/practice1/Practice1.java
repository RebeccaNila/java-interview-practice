package dev.nila.java.streams.practice1;

import dev.nila.java.Util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Practice1 {
//    Problem: Employee Analysis Description: You have a list of Employee objects.
//    class Employee { String name; String department; double salary; }

//    Task: Write a single Java Stream pipeline that returns a Map<String, Optional<Employee>>.
//
//    The Key should be the department.
//
//    The Value should be the Employee with the highest salary in that department.
//
//    Senior Constraint: Do not use a for loop. Use Collectors.groupingBy and Collectors.maxBy.
    private static final List<Employee> employeeList = EmployeeData.getAllEmployees();
    public static void main(String[] args) {
        Map<String, List<Employee>> collect = employeeList.stream()
                .collect(Collectors.groupingBy(e -> e.getDept()));

       //System.out.println(collect.toString());
//        collect.forEach((key,value) -> System.out.println("Key: "+key+"\nValue: "+value));
//        Util.mapPrintMethod(collect);
    }


}
