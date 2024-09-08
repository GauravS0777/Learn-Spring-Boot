package com.gauravcoding.multithreading;

import com.gauravcoding.multithreading.dto.User;
import com.gauravcoding.multithreading.service.GitHubLookupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class AppRunner implements CommandLineRunner {

  private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

  private final GitHubLookupService gitHubLookupService;

  public AppRunner(GitHubLookupService gitHubLookupService) {
    this.gitHubLookupService = gitHubLookupService;
  }

  @Override
  public void run(String... args) throws Exception {
    // Start the clock
    long start = System.currentTimeMillis();

    // Kick of multiple, asynchronous lookups
//    User page1 = gitHubLookupService.findUser("PivotalSoftware");
//    User page2 = gitHubLookupService.findUser("CloudFoundry");
//    User page3 = gitHubLookupService.findUser("Spring-Projects");

    CompletableFuture<User> page1 = gitHubLookupService.findUser("PivotalSoftware");
    CompletableFuture<User> page2 = gitHubLookupService.findUser("CloudFoundry");
    CompletableFuture<User> page3 = gitHubLookupService.findUser("Spring-Projects");

    Thread.sleep(1000);

    // Wait until they are all done
    CompletableFuture.allOf(page1, page2, page3).join();

    // Print results, including elapsed time
    logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
    logger.info("--> " + page1);
    logger.info("--> " + page2);
    logger.info("--> " + page3);
  }
}
