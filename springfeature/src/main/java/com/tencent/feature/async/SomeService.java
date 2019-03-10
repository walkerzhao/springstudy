package com.tencent.feature.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

import org.springframework.stereotype.Component;

@Component
public class SomeService {

  @AsyncTimed
  public CompletableFuture<String> getMessage() {
    return CompletableFuture.supplyAsync(() -> {
      System.out.println("begin async work.");
      heavyWork();
      System.out.println("async work end.");
      return "hello async world";
    }, ForkJoinPool.commonPool());
  }

  private void heavyWork() {
    try {
      Thread.sleep(10000);
    }
    catch (InterruptedException e) {
      Thread.interrupted();
    }
  }
}