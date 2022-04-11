package com.example.lab1_cpp.controller;

import com.example.lab1_cpp.counter.RequestCounter;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RequestCounterController {
    private static final Logger logger = LogManager.getLogger(RequestCounterController.class);

    @GetMapping(value = "/requestNumber")
    public String getCounter(){
        logger.info("RequestCounterController was called");
        return RequestCounter.getCounter() - 1 + " requests were executed";
    }

}
