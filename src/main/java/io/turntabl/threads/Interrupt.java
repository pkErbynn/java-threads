package io.turntabl.threads;

public class Interrupt {
  public static void main(String[] args) throws InterruptedException{
    Thread t = new Thread (() -> {
      while (!Thread.interrupted()) {
        System.out.print(".");
      }
    });
  
    System.out.println("Hello from this thread");
    Thread.sleep(1000);
    
    t.interrupt();
  }
}
