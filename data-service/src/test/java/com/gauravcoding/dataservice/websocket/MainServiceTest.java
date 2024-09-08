package com.gauravcoding.dataservice.websocket;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.mockito.Mockito.*;

public class MainServiceTest {
  @Test
  public void testConsumerReinitiationOnConnectionError() throws Exception {
    // Create a spy of MainService to verify reinitialization


    AtomicBoolean isFlag = new AtomicBoolean(false);

    MainService mainService = spy(new MainService(isFlag));

    ExecutorService executor = Executors.newSingleThreadExecutor();
    Future<Boolean> consumerFuture =
        executor.submit(
            () -> {
              mainService.startConsumer();
              return true;
            });

    // Call the startConsumer method

    while (isFlag.get() != true) {
      System.out.println(Thread.currentThread().getName() + " waiting for isFalg to true...");
      Thread.sleep(1000);
    }

    // Verify that restartConsumer was called due to the connection error
    verify(mainService, atLeastOnce()).restartConsumer();

    // Shut down the executor
    mainService.shutdown();
  }
}
