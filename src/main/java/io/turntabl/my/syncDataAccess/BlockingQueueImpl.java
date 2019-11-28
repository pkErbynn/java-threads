package io.turntabl.my.syncDataAccess;

public class BlockingQueueImpl implements Queue {
  private final Object lock = new Object();
  
  private final int CAPACITY = 6;
  private int[] buffer = new int[CAPACITY];
  private int next = 0;
  
  private boolean isFull = false;
  private boolean isEmpty = true;
  
  @Override
  public void add(int num) {
    synchronized (lock) {
      while (isFull) {
        try {
          lock.wait();
        } catch (InterruptedException ie) {
        }
      }
      buffer[next++] = num;
      if (next == CAPACITY) {
        isFull = true;
      }
      isEmpty = false;
  
      lock.notifyAll();
    }
  }
  
  @Override
  public int take() {
    synchronized (lock) {
      while (isEmpty == true) {
        try {
          lock.wait();
        } catch (InterruptedException ie) {
        }
      }
  
      next--;
  
      if (next == 0) {
        isEmpty = true;
      }
  
      isFull = false;
      lock.notifyAll();
      return (buffer[next]);
    }
  }
}
