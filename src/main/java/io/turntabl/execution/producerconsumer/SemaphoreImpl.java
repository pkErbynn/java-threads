package io.turntabl.execution.producerconsumer;

import java.util.concurrent.Semaphore;

public class SemaphoreImpl implements Queue {
  private final Object lock = new Object();
  
  private final int CAPACITY = 6;
  private int[] buffer = new int[CAPACITY];
  private int next = 0;
  
  private Semaphore nums = new Semaphore(0);
  private Semaphore spaces = new Semaphore(CAPACITY);
  
  @Override
  public void add(int num) {
    try{
      spaces.acquire();
    }catch(InterruptedException ie){}
    
    synchronized (lock){
      buffer[next++] = num;
    }
    nums.release();
  }
  
  @Override
  public int take() {
    try{
      nums.acquire();
    }catch(InterruptedException ie){}
    
    int ret;
    synchronized (lock){
      ret = buffer[--next];
    }
    spaces.release();
    return ret;
  }
}
