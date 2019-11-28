package io.turntabl.threads;

public class Stack {
  public static void main(String[] args){
    System.out.println(one(1));
  }
  
  public static int one(int i){
    return two(i);
  }
  
  public static int two(int i){
    return three(i);
  }
  
  public static int three(int i){
    return i;
  }
}
