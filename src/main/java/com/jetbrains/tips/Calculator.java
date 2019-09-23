package com.jetbrains.tips;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int sum(int[] items) {
        int result = 0;

        for (int item : items) {
            result += item;
        }

        return result;
    }
}
