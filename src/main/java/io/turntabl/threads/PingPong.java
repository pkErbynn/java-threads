package io.turntabl.threads;

import java.util.stream.IntStream;

public class PingPong {
  public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread(() -> {
      try{
        Thread.sleep(100);
        System.out.println("ping");
      }catch(InterruptedException ie){}
    });
    Thread t2 = new Thread(() -> {
      try{
        Thread.sleep(150);
        System.out.println("pong");
      }catch(InterruptedException ie){}
    });
    
    t1.start();
    t2.start();
    
    System.out.println("Main thread dying");
    
  }
}
