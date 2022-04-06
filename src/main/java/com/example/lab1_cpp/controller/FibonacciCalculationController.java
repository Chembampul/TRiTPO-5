package com.example.lab1_cpp.controller;

import com.example.lab1_cpp.entity.Fibonacci;
import com.example.lab1_cpp.service.FibonacciCalculationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.LinkedHashMap;

@RestController
@Validated
public class FibonacciCalculationController {

    private static final Logger logger = LogManager.getLogger(FibonacciCalculationController.class);

    @Autowired
    private FibonacciCalculationService fibonacciCalculationService;

    @GetMapping("/calculation")
    public Fibonacci calculation(@RequestParam(value = "position") @Min(0) @Max(100) int position) {
        logger.info("Successfully logged");
        return fibonacciCalculationService.findFibonacciByPosition(position);
    }

    @GetMapping("/fibonacciHash")
    public LinkedHashMap<Integer, Fibonacci> getFibonacciHash(){
        logger.info("Full hash was printed");
        return fibonacciCalculationService.getHashMap();
    }
}

