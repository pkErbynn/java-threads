package io.turntabl.dataaccess;

import java.util.stream.IntStream;

public class Account {
  private Object lock = new Object();
  private int balance;
  
  public Account(int startBalance){
      this.balance = startBalance;
  }
  
  public void Deposit(int amount){
    synchronized (lock) {
      balance += amount;
    }
  }
  
  public void Withdraw(int amount){
    synchronized (lock) {
      balance -= amount;
    }
  }
  
  public static void main(String[] args) throws Exception{
    
    Account a = new Account(0);
    
    Thread t1 = new Thread(()->{
      IntStream.range(0, 1000000).forEach(i ->
        a.Deposit(1000));
      IntStream.range(0,1000000).forEach(i ->
        a.Withdraw(1000));
    });
    
    Thread t2 = new Thread(()->{
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
