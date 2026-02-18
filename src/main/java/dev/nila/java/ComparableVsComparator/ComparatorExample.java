package dev.nila.java.ComparableVsComparator;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Student {
    private int id;
    private String name;
    private int age;

    public Student(){

    }

    public Student(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public List<Student> getStudentList() {
        Student e1 = new Student(1, "Sachit", 25);
        Student e2 = new Student(2, "Kunal", 21);
        Student e3 = new Student(3, "Sumit", 28);
        Student e4 = new Student(4, "Pushpa", 31);
        Student e5 = new Student(5, "Manas", 18);
        return new ArrayList<>(Arrays.asList(e1, e2, e3, e4, e5));
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name=" + name + ", age=" + age + "}\n";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
public class ComparatorExample {

    public static void main(String[] args) {
        List<Student> studentList = new Student().getStudentList();
            /*
                e1.compareTo(e2)
                Returns +ve => e1>e2
                Returns 0 => e1=e2
                Returns -ve => e1<e2
             */
        Collections.sort(studentList, (a, b) -> {
            if(a.getId() == b.getId()){
                return 0;
            }else if(a.getId() < b.getId()){
                return 1;
            }else{
                return -1;
            }
        });
        System.out.println(studentList.toString());
    }

}
