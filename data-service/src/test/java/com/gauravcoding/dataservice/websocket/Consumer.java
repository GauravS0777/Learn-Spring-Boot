package com.gauravcoding.dataservice.websocket;

import java.util.concurrent.Callable;

public class Consumer implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        // Simulating a running consumer process
        try {
            Thread.sleep(5000); // Simulating some work

            System.out.println(Thread.currentThread().getName() + " Throwing exception 1");
            // Simulate connection error after some time
            throw new RuntimeException("Connection error occurred in the consumer");
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName() + " Throwing exception 2 before interupt");
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + " Throwing exception 2");
            throw new RuntimeException("Consumer was interrupted", e);
        }
    }

}
