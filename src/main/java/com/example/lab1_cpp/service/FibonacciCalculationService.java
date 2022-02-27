package com.example.lab1_cpp.service;

import com.example.lab1_cpp.entity.Fibonacci;
import org.springframework.stereotype.Service;

@Service
public class FibonacciCalculationService {

    public Fibonacci findFibonacciByPosition(int position){
        int result = 0;
        int fib1 = 1;
        int fib2 = 1;

        for (int i = 0; i < position - 2; i++){
            result = fib1 + fib2;
            fib1 = fib2;
            fib2 = result;
        }
        return new Fibonacci(result);
    }
}

