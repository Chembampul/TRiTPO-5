package com.example.lab1_cpp.counter;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class RequestCounterThread extends Thread{
    Logger logger = LogManager.getLogger(RequestCounterThread.class);

    public RequestCounterThread() {
        super();
        start();
    }

    public void run() {

        while (true) {
            try {
                logger.info(Thread.currentThread().getName() + "is waiting for execution");
                Synchronization.semaphore.acquire();
                RequestCounter.incrementation();
                logger.info("Incremented counter" + RequestCounter.getCounter());
                break;
            } catch (InterruptedException e) {
                logger.error("Thread was interrupted");
            }
        }
    }
}
