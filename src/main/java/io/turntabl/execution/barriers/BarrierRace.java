package io.turntabl.execution.barriers;

import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

public class BarrierRace {
  public static void main(String[] args){
    int horses = 5;

    CyclicBarrier b = new CyclicBarrier(horses,
      ()-> System.out.println("barrier reached"));
  
    IntStream.range(0, horses).forEach(i->
      new BarrierWorker(i, b).start()
    );
  }
}
