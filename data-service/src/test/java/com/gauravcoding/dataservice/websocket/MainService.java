package com.gauravcoding.dataservice.websocket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainService {
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    AtomicBoolean isFalg;
    public MainService(AtomicBoolean isFlag){
        this.isFalg = isFlag;
    }

    public void startConsumer() {
        Future<Boolean> consumerFuture = executor.submit(new Consumer());
        System.out.println(Thread.currentThread().getName() + " Starting consumer...");
        try {
            // Wait for the consumer to finish or throw an error
            consumerFuture.get();
        } catch (Exception e) {
            System.out.println("Error detected: " + e.getMessage());
            // Reinitialize connection logic
            System.out.println("Reinitializing connection...");
            restartConsumer();
        }
    }

    public void restartConsumer() {
        // Logic to restart consumer
        System.out.println(Thread.currentThread().getName() + " Restarting the consumer...");
        isFalg.set(true);
        startConsumer();
    }

    public void shutdown() {
    System.out.println(Thread.currentThread().getName() + " Shutting down main service thread");
        executor.shutdown();
    }
}
