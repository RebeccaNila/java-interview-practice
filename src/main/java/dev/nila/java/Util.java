package dev.nila.java;

import dev.nila.java.streams.practice1.Employee;

import java.util.List;
import java.util.Map;

public class Util {

    public static void mapPrintMethod(Map<String, List<Employee>> map){
        //1. The Quickest Way (Standard toString)
        System.out.println(map);
        //2. The Modern Way (Java 8+ forEach)
        map.forEach((key, value) -> {
            System.out.println("Key: " + key + ", Value: " + value);
        });
        //3. The "Stream" Way (Java 8+)
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()) // Optional: Sort by key
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));


        //4. The Classic Loop (Iterating entrySet)
        for (Map.Entry<String, List<Employee>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }

        /**
         * Method	                Best For	        Output Style
         * System.out.println(map)	Debugging	        {A=1, B=2}
         * map.forEach(...)	        Clean Code	        Custom
         * stream().forEach(...)	Sorting/Filtering	Custom
         * entrySet() Loop	        Performance/Legacy	Custom
         */
    }
}
