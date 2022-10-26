package uom.opensource.advancedjava.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class MyCalculatorTest {


    @Test
    void shouldAddTwoNumbers() {
        int actual = MyCalculator.add(1, 1);
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    void shouldSubtractTwoNumbers() {
        int actual = MyCalculator.subtract(1, 1);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void shouldMultiplyTwoPositiveNumbers() {
        int actual = MyCalculator.multiply(2, 3);
        int expected = 6;
        assertAll(
                () -> assertEquals(expected, actual),
                () -> assertTrue(actual > 0)
        );
    }

    @Test
    void shouldDivideTwoNumbers() {
        int actual = MyCalculator.divide(6, 3);
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Throws Arithmetic Exception When Divisor is Zero")
    void shouldThrowWhenDivideByZero() {
        assertThrows(ArithmeticException.class, () -> MyCalculator.divide(1, 0));
    }


    //  HAMCREST INTRO
    @Test
    void Hamcrest() {
        int actual = MyCalculator.divide(6, 3);
        assertThat(actual, is(equalTo(2)));
    }

    @Test
    void listShouldInitiallyBeEmpty() {
        List<Integer> list = Arrays.asList(5, 2, 4);
        assertThat(list, hasSize(3));
        // ensure the order is correct
        assertThat(list, contains(5, 2, 4));
        assertThat(list, containsInAnyOrder(2, 4, 5));
        assertThat(list, everyItem(greaterThan(1)));

    }
}