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
    public void shouldReturnZeroWhenOneSubOne() {
        Calculator calculator = new Calculator();
        int expected = 0;

        int actual = calculator.sub(1, 1);

        assertEquals(expected, actual);
    }
}
