package io.turntabl.my.syncDataAccess;

import java.util.Random;
import java.util.stream.IntStream;

public class Producer extends Thread {
  private Queue pool;
  private int reps;
  private Random nums;
  
  public Producer(Queue pool, String threadName, int reps){
    super(threadName);
    this.pool = pool;
    this.reps = reps;
    this.nums = new Random();
  }
  
  @Override public void run(){
    IntStream.range(0, reps).forEach(i->{
      int num = nums.nextInt(1000);
      pool.add(num);
      System.out.println("Thread " + getName() + " put  " + num);
      
      try{
        sleep(nums.nextInt(100));
      }catch(InterruptedException ie){}
    });
  }
}
