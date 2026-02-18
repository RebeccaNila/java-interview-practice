package dev.nila.java.streams.practice1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsPractice {
    /**
     * Practice Topics
     * forEach(Consumer)
     * filter(Predicate)
     * collect(Collector)
     * map(Function)
     * distinct()
     * flatMap(Function)
     * sorted(Comparator both ASC and DESC)
     * min() & max()
     * GroupBy
     * findFirst()
     * findAny()
     * anyMatch(Predicate)
     * allMatch(Predicate)
     * noneMatch(Predicate)
     * limit(long maxSize)
     * skip(long n)
     */
    private static final List<Employee> employeeList = EmployeeData.getAllEmployees();
    public static void main(String[] args) {
//        skipDemo();
        //limitDemo();
        //nonMatchDemo();
        //allMatchDemo();
        //anyMatchDemo();
        //findAnyDemo();
        //findFirstDemo();
        //groupByDemo();
        //minMaxDemo();
        sortedDemo();
        //flatMapDemo();
        //mapDemo();
        //filterDemo();
        //forEachDemo();
    }


    private static void skipDemo(){
        //take long as parameter
        List<Employee> skipEmployeeList = employeeList.stream().skip(5).toList();
        System.out.println(skipEmployeeList);
    }
    private static void limitDemo(){
        //take long as parameter
        List<Employee> topPaidEmployees = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(3)
                .toList();
        System.out.println(topPaidEmployees);
        System.out.println(topPaidEmployees.size());
        topPaidEmployees.stream().map(e -> e.getSalary()).forEach(System.out::println);

    }

    private static void nonMatchDemo(){
        //take Predicate as arguments and return true or false
        boolean developmentAnyMatch = employeeList.stream().noneMatch(e -> e.getDept().equals("Developmentss"));
        System.out.println("Is there none of the employee from the development department "+developmentAnyMatch);
    }

    private static void allMatchDemo(){
        //take Predicate as arguments and return true or false

        boolean minSalaryEmployee = employeeList.stream().allMatch(e -> e.getSalary() > 50000); // min salary we have 55000
        System.out.println("Is all employee get minimum salary "+minSalaryEmployee);

        boolean developmentAllMatch = employeeList.stream().allMatch(e -> e.getDept().equals("Development"));
        System.out.println("Is there all employee match from the development department "+developmentAllMatch);


    }

    private static void anyMatchDemo(){
        //take Predicate as arguments and return true or false

        boolean developmentAnyMatch = employeeList.stream().anyMatch(e -> e.getDept().equals("Developments"));
        System.out.println("Is there any employee match from the development department "+developmentAnyMatch);

    }

    private static void findAnyDemo(){
        //findAny use in parallel string

        System.out.println("First Any who works in Development ");
        Employee findAnyDevelopmentEmployee = employeeList.stream()
                .filter(e -> e.getDept().equals("Development"))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("There is no Employee who works in Development "));

        System.out.println(findAnyDevelopmentEmployee);

    }

    private static void findFirstDemo(){
        System.out.println("First Employee who works in Development ");
        Employee findFirstDevelopmentEmployee = employeeList.stream()
                        .filter(e -> e.getDept().equals("xyz"))
                                .findFirst()
                                .orElseThrow(() -> new IllegalArgumentException("There is no Employee who works in Development "));
        System.out.println(findFirstDevelopmentEmployee);
        employeeList.stream()
                .filter(e -> e.getGender().equals("Female"))
                .findFirst()
                .ifPresent(e -> System.out.println(e.getName()));
        System.out.println();
        Optional<Employee> optionalEmployee = employeeList.stream()
                .filter(e -> e.getDept().equals("Development"))
                .findFirst();
        System.out.println("First Employee who works in Development Department ");
        optionalEmployee.ifPresent(e -> System.out.println(e.getName()));
    }

    private static void groupByDemo(){

        Map<String, Long> employeeGroupCountMap = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("Employee Gender Count : "+employeeGroupCountMap);

        //result Gender -> [names]
        Map<String, List<String>> employeeGroupList =  employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender
                        , Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println("Employee Name by Gender ");
        System.out.println(employeeGroupList);

        Map<String, List<Employee>> employeeGroup = employeeList.stream()
                                                                .collect(Collectors.groupingBy(Employee::getGender));
        System.out.println("Employee List by Gender ");
        System.out.println(employeeGroup);

    }

    private static void minMaxDemo(){

        Optional<Employee> highestPaidEmployee = employeeList.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("Highest Paid Employee: "+highestPaidEmployee);


        Optional<Employee> lowestPaidEmployee = employeeList.stream()
                .min(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("Lowest Paid Employee: "+lowestPaidEmployee.toString());

        //get the highest salary employee
        System.out.println("Get the highest salary employee");

        //one way is sorted in descending and get(0)/getFirst()
        List<Employee> sortedEmployeesBySalaryDesc = employeeList.stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Employee::getSalary)))
                .toList();
//        Employee employeeWithMaxSalary =  sortedEmployeesBySalaryDesc.getFirst();

//        System.out.println(employeeWithMaxSalary.toString());

        //get the lowest salary employee
        //one way is sorted in ascending and get(0)/getFirst()
        List<Employee> sortedEmployeesBySalaryAsc = employeeList.stream()
                //which fields we want to compare
                //by default ASC
                .sorted(Comparator.comparing(Employee::getSalary))
                .toList();
//        Employee employeeWithMinSalary =  sortedEmployeesBySalaryAsc.getFirst();
        System.out.println("Get the lowest salary employee");
//        System.out.println(employeeWithMinSalary.toString());


    }

    private static void sortedDemo(){
        // Sort employees by Salary (Highest to Lowest)
        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .forEach(System.out::println);
        List<Employee> sortedEmployeesBySalaryAsc = employeeList.stream()
                //which fields we want to compare
                //by default ASC
                .sorted(Comparator.comparing(Employee::getSalary))
                .toList();
        System.out.println("Sorted Employees By Salary Ascending");
//        System.out.println(sortedEmployeesBySalary);
        sortedEmployeesBySalaryAsc.forEach(System.out::println);

        List<Employee> sortedEmployeesBySalaryDesc = employeeList.stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Employee::getSalary)))
                .toList();
        System.out.println("Sorted Employees By Salary Descending");
//        System.out.println(sortedEmployeesBySalaryDesc);
        sortedEmployeesBySalaryDesc.forEach(System.out::println);

    }

    private static void flatMapDemo(){
        //get Projects inside Employee Object using flatMap
        List<String> projects = employeeList.stream()
                                            .flatMap(employee -> employee.getProjects().stream())
                                            .map(project -> project.getName())
                                            .toList();

        System.out.println("Get Project Names from Employee List");
        System.out.println(projects);


        //get distinct Projects inside Employee Object using flatMap
        List<String> uniqueProjects = employeeList.stream()
                .flatMap(employee -> employee.getProjects().stream())
//                .map(project -> project.getName())
                .map(Project::getName)
                .distinct()
                .toList();

        System.out.println("Get Unique Project Names from Employee List");
        System.out.println(uniqueProjects);
    }

    private static void mapDemo(){
        //map
        //get single attribute from the Employee Object
        List<String> employeeNameList = employeeList.stream()
                //                .map(employee -> employee.getName())
                .map(Employee::getName)
                .toList();
        System.out.println("Employees Name only From Employee Object");
        System.out.println(employeeNameList);

        //get unique dept name list
        Set<String> departmentSet = employeeList.stream()
                .map(Employee::getDept)
                .collect(Collectors.toSet());
        System.out.println("Get Unique Employee Department using Set");
        System.out.println(departmentSet);
        //or  use with distinct get unique dept name list
        List<String> departmentList = employeeList.stream()
                .map(Employee::getDept)
                .distinct()
                .toList();
        System.out.println("Get Unique Employee Department using List");
        System.out.println(departmentList);

        //in case if we want to use nested objects using map
        //here we can get stream for nested
        //we need to use flatMap for nested objects
        List<Stream<String>> streamList = employeeList.stream()
                .map(employee -> employee.getProjects()
                        .stream()
                        .map(project -> project.getName())).toList();

        System.out.println(streamList.toString());

    }

    private static void filterDemo(){
        //filter with forEach
        //GetEmployee whose department is development
//        employeeList.stream()
//                .filter(employee -> employee.getDept().equals("Development")).forEach(System.out::println);
        //filter with toList
        List<Employee> developmentEmployeeList = employeeList.stream()
                .filter(employee ->  employee.getDept().equals("Development")).toList();
        System.out.println("Employee List from Development Dept");
        System.out.println(developmentEmployeeList);


        //GetEmployee whose department is development && salary must be 70000
//        employeeList.stream()
//                .filter(employee -> employee.getDept().equals("Development") && employee.getSalary() >= 70000.00)
//                .forEach(System.out::println);

        //GetEmployee EmployeeId and Name as a Map whose department is development && salary must be 70000
        Map<Integer, String> developmentEmployeeMap = employeeList.stream()
                .filter(employee -> employee.getDept().equals("Development") && employee.getSalary() >= 70000.00)
                .collect(Collectors.toMap(Employee::getId, Employee::getName));
        System.out.println("Employees from Development Dept and Salary Higher 70000");
        System.out.println(developmentEmployeeMap);

    }

    private static void forEachDemo(){
        //foreach
        employeeList.forEach(employee -> System.out.println(employee.getName()+" : "+employee.getSalary()));
        employeeList.forEach(System.out::println);
        employeeList.stream().forEach(System.out::println);
    }
}
