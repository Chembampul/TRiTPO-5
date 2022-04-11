package com.example.lab1_cpp.counter;

public class RequestCounter {
    private static int counter = 0;

    public static void incrementation(){
        counter++;
    }

    public static Integer getCounter(){
        return counter;
    }
}
