package dev.nila.java.streams;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

public class TerminalOperations {

    static List<String> names = Arrays.asList("Adam","Eve","Romeo");
    static List<Integer> numbers = Arrays.asList(2, 5, 6, 88, 5, 9, 3, 2 );
    static int[] primitiveNumbers = {1, 5, 2, 8, 3};

    public static void main(String[] args) {

        /**
         * 4 reduce() - Combine elements into a single value
         */
        int sum = numbers.stream().reduce(0 , Integer::sum);
        System.out.println(sum);

        /**
         * 3 count() - Return the number of elements in the stream
         */
        long count = numbers.stream().count();
        System.out.println(count);

        /**
         * 1 collect() - collects elements into a collection like a list or set
         */
        List<Integer> numberList = numbers.stream().collect(Collectors.toList());
        System.out.println(numberList);
        /**
         * 1 forEach() - Performs an action on each element
         */
        names.stream().forEach(System.out::println);

    }
}
