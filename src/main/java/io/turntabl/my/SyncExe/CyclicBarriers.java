package io.turntabl.my.SyncExe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CyclicBarriers implements Runnable{

    Thread t1 = new Thread(() ->
            System.out.println("horse one"));
    Thread t2 = new Thread(() ->
            System.out.println("horse two"));
    Thread t3 = new Thread(() ->
            System.out.println("horse three"));
    Thread t4 = new Thread(() ->
            System.out.println("horse four"));
    Thread t5 = new Thread(() ->
            System.out.println("horse five"));

    List<Thread> horses = Arrays.asList(t1, t2, t3, t4, t5 );

    @Override
    public void run() {
        try {
            System.out.println("Thread " + Thread.currentThread().getName() + " ready at barrier");
            horses.wait();
//            Thread.sleep();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
