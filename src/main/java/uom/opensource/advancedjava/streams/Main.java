package uom.opensource.advancedjava.streams;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Stream<Integer> stream = integers.stream();

        System.out.println("----------- FOR EACH -------------------");
        integers.stream().forEach(i -> System.out.println(i));
        // integers.forEach(i => console.log(i));

        System.out.println("----------- FILTER -------------------");
        List<Integer> greaterThan5 = integers.stream().filter(i -> i > 5).toList();
        greaterThan5.forEach(System.out::println);

        System.out.println("----------- MAP -------------------");
        integers.stream().map(i -> i * 2).forEach(i -> System.out.println(i));

        System.out.println("----------- SUM -------------------");
        int sum = integers.stream().mapToInt(i -> i).sum();
        System.out.println(sum);

        System.out.println("----------- AVERAGE -------------------");
        double asDouble = integers.stream().mapToInt(i -> i).average().getAsDouble();
        System.out.println(asDouble);

        System.out.println("----------- FIND FIRST -------------------");
        Optional<Integer> first = integers.stream().filter(i -> i > 5).findFirst();
        System.out.println(first.get());

        System.out.println("----------- FIND ANY -------------------");
        Optional<Integer> anyFirst = integers.parallelStream().filter(i -> i > 5).findAny();
        System.out.println(anyFirst.get());

        /*
        MORE ON JAVA STREAMS
        https://github.com/koushikkothagal/reactive-java-workshop/blob/master/src/main/java/io/javabrains/reactiveworkshop/Exercise1.java
        https://www.tutorialspoint.com/java8/java8_streams.htm
         */

    }
}