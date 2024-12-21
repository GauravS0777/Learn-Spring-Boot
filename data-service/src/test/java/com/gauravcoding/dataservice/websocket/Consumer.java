package com.gauravcoding.dataservice.websocket;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public class Consumer implements Callable<Boolean> {
  AtomicBoolean isBroken;

  public Consumer(AtomicBoolean isBroken) {
    this.isBroken = isBroken;
  }

  @Override
  public Boolean call() throws Exception {
    Thread.sleep(5000);
    isBroken.set(true);
    System.out.println(Thread.currentThread().getName() + " Consumer is broken");
    return true;
  }
}
