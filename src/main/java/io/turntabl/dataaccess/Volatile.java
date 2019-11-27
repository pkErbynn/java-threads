package io.turntabl.dataaccess;

import io.turntabl.threads.Interrupt;

public class Volatile {
  private volatile boolean setupComplete = false;
  private String config = "";
  
  public static void main(String[] args) throws Exception{
    Volatile v = new Volatile();
    
    Thread t1 = new Thread(()->{
      try{
      Thread.sleep(3000);
      v.config = "application config";
      v.setupComplete = true;
      }catch(InterruptedException e){}
    });
    
    Thread t2 = new Thread(()->{
      while(!v.setupComplete){}
      //read config
      System.out.println(v.config);
    });
    
    t1.start();
    t2.start();
    
    t1.join();
    t2.join();
    
  }
  
}
