package io.turntabl.my;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Threads2 {
    public static void main(String[] args) throws InterruptedException {

        List<Thread> _10Threads = IntStream.range(1, 11).mapToObj(
                e -> new Thread(() -> {
                    while (!Thread.interrupted()) System.out.println("Thread " + e + " Interrupted");
                }
                )
        ).collect(Collectors.toList());

        _10Threads.stream().forEach(e-> e.start ());

        System.out.println("Active threads running: " + Thread.activeCount());

//        Random random = new Random();
//        while (Thread.activeCount() != 1) {


        _10Threads.stream().forEach(thread -> {
            try {
                thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        _10Threads.stream().forEach(thread -> thread.interrupt());


        _10Threads.stream().forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });



    }


}
