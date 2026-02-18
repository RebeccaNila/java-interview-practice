package dev.nila.java.ComparableVsComparator;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;

class Employer implements Comparable<Employer> {
    private int id;
    private String name;
    private int age;

    public Employer(){

    }

    public Employer(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public List<Employer> getEmployerList() {
        Employer e1 = new Employer(1, "Sachit", 25);
        Employer e2 = new Employer(2, "Kunal", 21);
        Employer e3 = new Employer(3, "Sumit", 28);
        Employer e4 = new Employer(4, "Pushpa", 31);
        Employer e5 = new Employer(5, "Manas", 18);
        return new ArrayList<>(Arrays.asList(e1, e2, e3, e4, e5));
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

    @Override
    public String toString() {
        return "Employer{id=" + id + ", name=" + name + ", age=" + age + "}\n";
    }

    /*
        e1.compareTo(e2)
        Returns +ve => e1>e2
        Returns 0 => e1=e2
        Returns -ve => e1<e2
     */
    @Override
    public int compareTo(Employer o) {
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
public class ComparableAndComparator {

    public static void main(String[] args) {
        List<Employer> employerList = new Employer().getEmployerList();
        //Collections.sort(employerList);
        Collections.sort(employerList, (a, b) -> {
            if(a.getId() == b.getId()){
                return 0;
            }else if(a.getId() < b.getId()){
                return 1;
            }else{
                return -1;
            }
        });
        System.out.println(employerList.toString());
    }
}
