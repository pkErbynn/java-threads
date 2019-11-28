package io.turntabl.my.barriers;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarrierWorker extends Thread {
  private CyclicBarrier barrier;
  
  public BarrierWorker(int i, CyclicBarrier barrier){
    super("worker-" + i);
    this.barrier = barrier;
  }
  
  @Override
  public void run(){
    try{
      System.out.println("thread " + Thread.currentThread().getName() + " ready");
      barrier.await();
      Thread.sleep((int)(Math.random() * 10000));
      System.out.println("thread " + Thread.currentThread().getName() + " finished");
      barrier.await();
    }
    catch(InterruptedException ie){}
    catch(BrokenBarrierException bbe){}
  }
  
}
