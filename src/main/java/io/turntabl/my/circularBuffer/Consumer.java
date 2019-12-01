package io.turntabl.my.circularBuffer;

import java.util.stream.IntStream;

public class Consumer extends Thread{
    CircularBufferImpl circularBuffer;

    public Consumer(CircularBufferImpl circularBuffer) {
        this.circularBuffer = circularBuffer;
    }

    public void consumeItem() throws InterruptedException {
        int data = circularBuffer.removeItem();
        Thread.sleep(1000);
        System.out.println("Consume: " + data);
    }


    @Override
    public void run() {
        IntStream.range(0, 4).forEach(e -> {
            while (this.circularBuffer.getCurrentBufferSize() == 0) {
                Thread.yield();
            }
            try {
                Thread.sleep(1000);
                this.consumeItem();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
    }
}
