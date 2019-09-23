package com.jetbrains.tips;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void shouldReturnTwoWhenOneAddOne() {
        Calculator calculator = new Calculator();
        int expected = 2;

        int actual = calculator.add(1, 1);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnZeoWhenOneSubOne() {
        Calculator calculator = new Calculator();
        int expected = 0;

        int actual = calculator.sub(1, 1);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnSixWhenGivenAnArray() {
        Calculator calculator = new Calculator();
        int[] items = new int[] {1, 2, 3};
        int expected = 6;

        int actual = calculator.sum(items);

        assertEquals(expected, actual);
    }
}
