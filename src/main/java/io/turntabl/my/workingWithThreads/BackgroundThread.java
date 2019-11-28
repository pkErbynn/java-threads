package io.turntabl.my.workingWithThreads;

import java.util.stream.IntStream;

public class BackgroundThread {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
//            System.out.println("thread 1");
            IntStream.range(0, 10).forEach(e -> System.out.println("thread 1: "+ e));
            try {Thread.sleep(10000);} catch (InterruptedException e) {e.printStackTrace();}

        });
        t1.setName("ThreadName: 1");

        Thread t2 = new Thread(() -> {
//            System.out.println("thread 2");
            IntStream.range(0, 10).forEach(e -> System.out.println("thread 2: "+ e));
            try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
        }, "ThreadName: 2");

        t1.start();
        Thread.sleep(10);     // 1sec diff after t1
        t2.start();

        System.out.println("t1 alive?: " + t1.isAlive());

        t1.join();      // main wait for these threads b4 it runs & close prog...technically, runs last
        t2.join();

        System.out.println("t1 alive?: " + t1.isAlive());

        System.out.println("main thread");
        System.out.println(t1.getName());
        System.out.println(t2.getName());

    }
}
