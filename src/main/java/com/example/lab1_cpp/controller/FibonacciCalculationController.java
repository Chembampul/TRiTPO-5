package com.example.lab1_cpp.controller;

import com.example.lab1_cpp.ExceptionInfo;
import com.example.lab1_cpp.service.FibonacciCalculationService;
import com.example.lab1_cpp.entity.Fibonacci;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Validated
@RestController

public class FibonacciCalculationController{

    private static final Logger logger = LogManager.getLogger(FibonacciCalculationController.class);

    @Autowired
    private FibonacciCalculationService fibonacciCalculationService;

    @GetMapping("/calculation")
    public Fibonacci calculation(@RequestParam (value = "position", defaultValue = "0") @Min(0)  int position )
            throws ConstraintViolationException {
        logger.info("Successsfuly logged");
        return fibonacciCalculationService.findFibonacciByPosition(position);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handlerException(ConstraintViolationException e){
        ExceptionInfo error = new ExceptionInfo(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        logger.info("Error 400");
       return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerBadRequestException(Exception e){
        ExceptionInfo error = new ExceptionInfo(e.getMessage(), 500);
        logger.info("Error 500");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}

