package com.example.lab1_cpp.controller;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

public class FibonacciCalculationControllerTest {
    @Test
    public void positiveValue() {

        FibonacciCalculationController fibonacciCalculationController = new FibonacciCalculationController();
        int actual = fibonacciCalculationController.calculation(9).getValue();
        int expected = 34;
       assertEquals(expected, actual);
    }

}