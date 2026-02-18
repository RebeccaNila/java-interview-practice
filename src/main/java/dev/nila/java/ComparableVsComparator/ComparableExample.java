package dev.nila.java.ComparableVsComparator;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;

class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private int age;

    public Employee(){

    }

    public Employee(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public List<Employee> getEmployeeList() {
        Employee e1 = new Employee(1, "Sachit", 25);
        Employee e2 = new Employee(2, "Kunal", 21);
        Employee e3 = new Employee(3, "Sumit", 28);
        Employee e4 = new Employee(4, "Pushpa", 31);
        Employee e5 = new Employee(5, "Manas", 18);
        return new ArrayList<>(Arrays.asList(e1, e2, e3, e4, e5));
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name=" + name + ", age=" + age + "}\n";
    }

    /*
        e1.compareTo(e2)
        Returns +ve => e1>e2
        Returns 0 => e1=e2
        Returns -ve => e1<e2
     */
    @Override
    public int compareTo(Employee o) {
        //return Integer.compare(this.id, o.id);
        if(this.id == o.id){
            return 0;
        }else if(this.id > o.id){
            return 1;
        }else{
            return -1;
        }

    }

}

public class ComparableExample {

    public static void main(String[] args) {
        List<Employee> employeeList = new Employee().getEmployeeList();
        Collections.sort(employeeList);
        System.out.println(employeeList.toString());
    }


}


