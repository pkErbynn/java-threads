package io.turntabl.my.workingWithThreads;

public class SharedData {
    private volatile boolean isSetupDone = false;       // volatile => threads share data from diff their resp world
    private String setUp = "";

    public static void main(String[] args) {
        SharedData vola = new SharedData();

        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {e.printStackTrace();}
            vola.setUp = "application setup";
            vola.isSetupDone = true;
        });

        Thread t2 = new Thread(() -> {
            while (!vola.isSetupDone) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread 1 done...setUp = " + vola.setUp);
            }
        });

        t1.start();
        t2.start();
    }

}
