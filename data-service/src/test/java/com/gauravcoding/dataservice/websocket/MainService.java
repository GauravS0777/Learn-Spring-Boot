package com.gauravcoding.dataservice.websocket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainService {
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    AtomicBoolean isFlag;
    AtomicBoolean isBroken;
    public MainService(AtomicBoolean isFlag, AtomicBoolean isBroken){
        this.isFlag = isFlag;
        this.isBroken = isBroken;
    }

    public void startConsumer() {
        System.out.println(Thread.currentThread().getName() + " Starting consumer...");
        executor.submit(new Consumer(isBroken));
    }

    public void restartConsumer() {
        // Logic to restart consumer
        System.out.println(Thread.currentThread().getName() + " Restarting the consumer...");
        isFlag.set(true);
        startConsumer();
    }

    public void shutdown() {
    System.out.println(Thread.currentThread().getName() + " Shutting down main service thread");
        executor.shutdown();
    }
}
