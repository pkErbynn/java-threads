package io.turntabl.threads;

public class Threads {
  public static void main(String[] args) throws InterruptedException{
    Thread t = new Thread (() ->
      System.out.print("."));
  
    t.start();
  
    System.out.println("Hello from this thread");
  
    t.join();
  }
}
