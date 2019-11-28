package io.turntabl.my.barriers;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

public class BarrierRace implements Runnable{
  public static void main(String[] args) {
      int horses = 5;

      CyclicBarrier horse1 = new CyclicBarrier(horses,
              () -> System.out.println("barrier reached"));
      CyclicBarrier horse2 = new CyclicBarrier(horses,
              () -> System.out.println("barrier reached"));
      CyclicBarrier horse3 = new CyclicBarrier(horses,
              () -> System.out.println("barrier reached"));
      CyclicBarrier horse4 = new CyclicBarrier(horses,
              () -> System.out.println("barrier reached"));
      CyclicBarrier horse5 = new CyclicBarrier(horses,
              () -> System.out.println("barrier reached"));

      List<CyclicBarrier> cHorses = Arrays.asList(horse1, horse2, horse3, horse4, horse5);


//    IntStream.range(0, horses).forEach(i->
//      new BarrierWorker(i, b).start()
//    );


//  }

//  @Override
//  public void run() {
//    try {
//      System.out.println("Thread " + Thread.currentThread().getName() + " ready at barrier");
//      cHorses.wait();
//      Thread.sleep();
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//
//  }
///}
  }

    @Override
    public void run() {

    }
}