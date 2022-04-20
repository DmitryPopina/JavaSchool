package com.github.dmitrypopina.javaschool.lesson5_reflection;

public class CalculatorImpl implements Calculator {
    @Override
    @Metric
    public int calc(int number) {
        int result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
