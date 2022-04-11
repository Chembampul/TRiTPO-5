package com.example.lab1_cpp.service;

import com.example.lab1_cpp.entity.Fibonacci;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

@Component
public class FibonacciCalculationHash {

private final LinkedHashMap<Integer, Fibonacci> linkedHashMap = new LinkedHashMap<>();

public boolean findByKey(int key){
    return linkedHashMap.containsKey(key);
}

public void addToMap(int key, Fibonacci result){
    linkedHashMap.put(key, result);
}

public Fibonacci getParameters(int key){
    return linkedHashMap.get(key);
}

public LinkedHashMap<Integer, Fibonacci> getFullHash(){ return linkedHashMap; }

}
