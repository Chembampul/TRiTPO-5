package com.example.lab1_cpp;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/greeting")


    public Greetings greeting(@RequestParam(value = "count", defaultValue = "0") String name) {
        // return new Greetings(Integer.parseInt(name));
        int result = 0;
        int fib1 = 1;
        int fib2 = 1;
        for(int i = 0; i<Integer.parseInt(name)-2; i++){
            result = fib1 + fib2;
            fib1 = fib2;
            fib2 = result;
        }
        return new Greetings(result);
    }



}