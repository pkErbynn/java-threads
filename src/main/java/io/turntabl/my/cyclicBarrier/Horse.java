package io.turntabl.my.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Horse extends Thread {
  private CyclicBarrier barrier;

  public Horse(int i, CyclicBarrier barrier){
    super("horse: " + i);
    this.barrier = barrier;
  }

  @Override
  public void run(){
    try{
      System.out.println(Thread.currentThread().getName() + " ready");
      barrier.await();
      Thread.sleep((int)(Math.random() * 10000));
      System.out.println(Thread.currentThread().getName() + " finished");
      barrier.await();
    }
    catch(InterruptedException ie){}
    catch(BrokenBarrierException bbe){}
  }
  
}
