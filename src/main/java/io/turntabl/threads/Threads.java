package io.turntabl.threads;

public class Threads {
  public static void main(String[] args) throws InterruptedException{
    Thread t = new Thread (() ->
      System.out.println("bg thread..."));


    System.out.println("Hello from main thread");

    t.start();
    t.join();
  }
}
