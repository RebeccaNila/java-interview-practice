package dev.nila.java.streams;

import java.util.List;
import java.util.Arrays;
import java.util.stream.*;

public class CreatingStreamsMultipleWays {

    public static void main(String[] args) {

        /**
         * 1
         * From Collections(List, Set, Map)
         * Collections in java have a stream() method
         */
        List<String> names = Arrays.asList("Adam","Eve","Madhan");
        Stream<String> nameStream = names.stream();
        nameStream.forEach(System.out::println);
        //simple way
        names.stream().forEach(System.out::println);

        /**
         * 2
         * From Arrays
         * Arrays.stream() to create a stream from and array
         *
         */
        int[] numbers = {2, 4, 56, 76, 9};
        IntStream numberStream = Arrays.stream(numbers);
        numberStream.forEach(System.out::println);

        /**
         * 3
         * Using Stream.of()
         * Stream.of() creates a stream from individual elements or and array
         */
        Stream<String> fruitStream = Stream.of("Apple", "Mango", "Banana");
        fruitStream.forEach(System.out::println);

        /**
         * 4
         * Generating Streams
         * Stream.generate() - to create and infinite stream of value.
         * to stop this you can use limit
         */
        Stream<String> helloStream = Stream.generate(() -> "Hello").limit(5);
        helloStream.forEach(System.out::println);

        /**
         * 5
         * Creating a Stream with Stream.iterate() - to create and infinite stream of value.
         * Example: generating numbers starting from 5
         * to stop this you can use limit
         *
         */

        Stream<Integer> numbStream = Stream.iterate(5, n -> n+1).limit(7);
        numbStream.forEach(System.out::println);
    }
}
