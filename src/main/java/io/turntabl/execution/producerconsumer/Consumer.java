package io.turntabl.execution.producerconsumer;

import java.util.Random;
import java.util.stream.IntStream;

public class Consumer extends Thread {
  private Queue pool;
  private int reps;
  private Random nums;
  
  public Consumer(Queue pool, String threadName, int reps){
    super(threadName);
    this.pool = pool;
    this.reps = reps;
    this.nums = new Random();
  }
  
  @Override public void run(){
    IntStream.range(0, reps).forEach(i->{
      int num = pool.take();
      System.out.println("Thread " + getName() + " took " + num);
      try{
        sleep(nums.nextInt(100));
      }catch(InterruptedException ie){}
    });
  }
}
