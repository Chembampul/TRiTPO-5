package com.example.lab1_cpp.service;

import com.example.lab1_cpp.counter.RequestCounterThread;
import com.example.lab1_cpp.entity.Fibonacci;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Service
public class FibonacciCalculationService {
    private static final Logger logger = LogManager.getLogger(FibonacciCalculationService.class);

    @Autowired
    private FibonacciCalculationHash linkedHashMap;

    public  FibonacciCalculationService(FibonacciCalculationHash linkedHashMap) { this.linkedHashMap = linkedHashMap; }

    public LinkedHashMap<Integer, Fibonacci> getHashMap(){ return linkedHashMap.getFullHash(); }

    public Fibonacci findFibonacciByPosition(int position){
        new RequestCounterThread(Thread.currentThread().getName()).start();
        int result = 0;

        if (linkedHashMap.findByKey(position)){
            result = linkedHashMap.getParameters(position).getValue();
            logger.info("get hashMap");
        }
        else {
            int fib1 = 1;
            int fib2 = 1;

            for (int i = 0; i < position - 2; i++) {
                result = fib1 + fib2;
                fib1 = fib2;
                fib2 = result;
            }

            linkedHashMap.addToMap(position, new Fibonacci(result));
        }
        return new Fibonacci(result);
    }



}



