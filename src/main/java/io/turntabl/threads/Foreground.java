package io.turntabl.threads;

import java.util.stream.IntStream;

public class Foreground {
  public static void main(String[] args) throws InterruptedException {
    Thread t = new Thread(() -> {
      IntStream.range(0, 1000).forEach(i -> System.out.print("."));
      System.out.println("Second thread dying");
      
    });
//    t.setDaemon(false);
    t.start();
    System.out.println("\nMain thread dying");

  }
}
