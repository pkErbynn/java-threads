package io.turntabl.my.syncDataAccess;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.IntStream;

public class ArrayBlockiningQueue {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(20);

        Thread producer = new Thread(() ->
                IntStream.range(0, 20).forEach(e -> {   // creating 20 prod threads
                    try {Thread.sleep(1000);} catch (InterruptedException ex) {ex.printStackTrace();}
                    System.out.println("producer: " + queue.offer(e));
                    Thread.yield();
                }));

        Thread consumer = new Thread(() ->
                IntStream.range(0, 20).forEach(e -> {
                    try {Thread.sleep(1000);} catch (InterruptedException ex) {ex.printStackTrace();}
                    System.out.println("consumer: " + queue.poll());
                    Thread.yield();
                }));

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }

}
