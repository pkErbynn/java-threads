package io.turntabl.my.syncDataAccess;

public class Driver {
  private static Queue pool = new SemaphoreImpl();
  
  public static void main(String[] args){
    int reps = 100;
    new Producer(pool, "p1", reps).start();
    new Producer(pool, "p2", reps).start();
    new Consumer(pool, "c1", reps).start();
    new Consumer(pool, "c2", reps).start();
  }
}
