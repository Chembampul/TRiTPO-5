package com.example.lab1_cpp.counter;

public class RequestCounter {
    private static int counter;

    public static void increment(){
        ++counter;
    }

    public static Integer getCounter(){
        return counter;
    }
}
