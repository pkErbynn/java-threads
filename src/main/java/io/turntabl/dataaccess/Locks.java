package io.turntabl.dataaccess;

import java.util.concurrent.locks.ReentrantLock;

public class Locks {
  public static void main(String[] args){
    ReentrantLock l = new ReentrantLock();
    l.lock();
    try{
      //do whatever
    }finally{
      l.unlock();
    }
  }
}


