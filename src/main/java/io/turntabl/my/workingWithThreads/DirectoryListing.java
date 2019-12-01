package io.turntabl.my.workingWithThreads;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.stream.IntStream;


public class DirectoryListing {
    public static void main(String[] args) throws IOException, InterruptedException {
        Thread listThread = new Thread(() -> {
            File dir = new File("folder");
            dir.mkdir();

//            while (!Thread.interrupted()){
            String[] dirContents = dir.list();
            if (dir.isDirectory()) {
                    IntStream.range(0, dirContents.length).forEach(
                            e -> {
                                try {Thread.sleep(3000);} catch (InterruptedException ex) {ex.printStackTrace();}
                                System.out.println(dirContents[e]);
                            }
                    );

//                for (int i = 0; i < dirContents.length; ++i) {
//                    try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
//                    System.out.println(dirContents[i]);
//                }
//            }
            }
            System.out.println(dir.getAbsoluteFile());
        });

        listThread.start();
//        Thread.sleep(7000);
//        listThread.interrupt();

    }
}
