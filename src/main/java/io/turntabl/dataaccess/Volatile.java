package io.turntabl.dataaccess;

import io.turntabl.threads.Interrupt;

public class Volatile {
  private boolean setupComplete = false;
  private String config = "";
  
  public static void main(String[] args) throws Exception{
    Volatile v = new Volatile();
  
    /*
    t1 is responsible for reading and setting up
    the application configuration.
     */
    Thread t1 = new Thread(()->{
      try{
      Thread.sleep(3000);
      //write config
      v.config = "application config";
      v.setupComplete = true;
      }catch(InterruptedException e){}
    });
    
    /*
    t2 can only do useful work once the config
    is setup. The volatile variable means reads
    to setupComplete are not cached.
    Try removing the volatile keyword and re-running.
    What happens? Why?
     */
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
