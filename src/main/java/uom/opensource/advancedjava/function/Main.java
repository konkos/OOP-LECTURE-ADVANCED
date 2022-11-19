package uom.opensource.advancedjava.function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<String, Integer> stringIntegerFunction = (s) -> {
            System.out.println(s);
            return s.length();
        };

        Integer apply = stringIntegerFunction.apply("123");
        System.out.println(apply);


        BiFunction<Integer, Integer, Integer> biFunction = (i1, i2) -> i1 + i2;
    }
}
