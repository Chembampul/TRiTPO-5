package com.example.lab1_cpp.controller;

import com.example.lab1_cpp.service.FibonacciCalculationService;
import com.example.lab1_cpp.entity.Fibonacci;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FibonacciCalculationController{

    @Autowired
    private FibonacciCalculationService fibonacciCalculationService;

    @GetMapping("/calculation")

    public Fibonacci calculation(@RequestParam(value = "position", defaultValue = "0") int position) {

        return fibonacciCalculationService.findFibonacciByPosition(position);

    }
}