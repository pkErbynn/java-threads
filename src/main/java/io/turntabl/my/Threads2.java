package io.turntabl.my;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Threads2 {
    public static void main(String[] args) {

        List<Thread> _10Threads = IntStream.range(1, 11).mapToObj(
                e -> new Thread(() -> {
                    while (!Thread.interrupted()) System.out.println("Thread " + e + "Uninterrupted");
                }
                )
        ).collect(Collectors.toList());

        _10Threads.stream().forEach(e-> e.start());


    }


}
