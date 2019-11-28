package io.turntabl.threads;

import java.util.stream.IntStream;

public class Foreground {
  public static void main(String[] args) throws InterruptedException {
    Thread t = new Thread(() -> {
      IntStream.range(0, 10000).forEach(i -> System.out.print("."));
      System.out.println("Second thread dying...");
      
    });
    
    t.start();
    
    System.out.println("Main thread dying");
    
  }
}
