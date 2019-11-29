package io.turntabl.my.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

public class HorseRace {
  public static void main(String[] args){
    int horses = 5;

    CyclicBarrier b = new CyclicBarrier(horses,
      ()-> System.out.println("barrier reached"));

    IntStream.range(0, horses).forEach(i->
      new Horse(i, b).start()
    );
  }
}
