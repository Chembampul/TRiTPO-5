package com.example.lab1_cpp.service;

import com.example.lab1_cpp.entity.Fibonacci;
import org.springframework.stereotype.Component;

import java.util.HashMap;
@Component
public class FibonacciCalculationHash {

private final HashMap<Integer, Fibonacci> hashMap = new HashMap<>();

public boolean isContain(int key){
    return hashMap.containsKey(key);
}

public void addToMap(int key, Fibonacci result){
    hashMap.put(key, result);
}

public Fibonacci getParameters(int key){
    return hashMap.get(key);
}

}
