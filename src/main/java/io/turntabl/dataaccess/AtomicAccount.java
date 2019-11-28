package io.turntabl.dataaccess;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class AtomicAccount {
  private AtomicInteger balance = new AtomicInteger(); // meaning...only one thread can access at a time
  
  public AtomicAccount(int startBalance){
    this.balance.set(startBalance);
  }
  
  public void Deposit(int amount){
    balance.addAndGet(amount);
  }
  
  public void Withdraw(int amount){
    balance.addAndGet(-amount);
  }
  
  public static void main(String[] args) throws Exception{
  
    AtomicAccount a = new AtomicAccount(0);
    
    Thread t1 = new Thread(()->{
      System.out.println("t1");
      IntStream.range(0, 1000000).forEach(i ->
        a.Deposit(1000));
      IntStream.range(0,1000000).forEach(i ->
        a.Withdraw(1000));
    });
    
    Thread t2 = new Thread(()->{
      System.out.println("t2");
      IntStream.range(0, 1000000).forEach(i ->
        a.Deposit(1000));
      IntStream.range(0,1000000).forEach(i ->
        a.Withdraw(1000));
    });
    
    t1.start();
    t2.start();
    
    t1.join();
    t2.join();
    
    System.out.println(a.balance);
  }
}
