package io.turntabl.my;

public class Threads1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("thread 1");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
//            for(int i = 0; i<=10000; i++){
//            }
            System.out.println("thread 2");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

//        Thread.sleep(30000); // affect main thread...waits for 3secs for t1,t2 to finish b4
        t1.join();      // main will always wait for others b4 prog close
        t2.join();

        System.out.println("main thread");


    }
}
