package dev.nila.java.streams;

import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

public class IntermediateOperation {

    static List<String> names = Arrays.asList("Adam","Eve","Romeo");
    static List<Integer> numbers = Arrays.asList(2, 5, 6, 88, 5);
    static int[] primitiveNumbers = {1, 5, 2, 8, 3};

    public static void main(String[] args) {


        /**
         * 4
         * distinct() - to remove duplicate elements from the stream
         */
        System.out.println("Remove duplicate elements ");
        numbers.stream()
                .distinct()
                .forEach(System.out::println);

        /**
         * Sorting a Stream of Primitives (int, double, etc.)
         * Java's primitive streams (IntStream, LongStream, DoubleStream) do not have a sorted(Comparator) method.
         * They only have a default sorted() method which sorts in natural (ascending) order.
         * To reverse sort primitives, you must first "box" them into their wrapper objects.
         */
        System.out.println("Descending order ");
        Arrays.stream(primitiveNumbers)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
        System.out.println("Ascending order ");
        //Ascending order
        Arrays.stream(primitiveNumbers).sorted().forEach(System.out::print);

        /**
         * 2 Sort
         * sorted() - Sorts elements in natural order or using comparator
         */

        numbers.stream().sorted().forEach(System.out::println);
        numbers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        /**
         * 1 Filter
         * filter() - filters elements based on the conditions
         */

        List<String> filtersNames = names.stream()
                .filter(n -> n.startsWith("E"))
                .toList();
        //in simpler way
        names.stream().filter(n -> n.startsWith("E")).forEach(System.out::println);
        filtersNames.forEach(System.out::println);

        /**
         * 2 Map
         * map() - Transform each elements in the stream
         *
         */
        names.stream().map(String::toUpperCase).forEach(System.out::println);



    }
}
