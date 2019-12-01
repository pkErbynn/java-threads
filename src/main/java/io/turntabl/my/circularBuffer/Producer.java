package io.turntabl.my.circularBuffer;

import java.util.stream.IntStream;

public class Producer extends Thread{
    CircularBufferImpl circularBuffer;
    private int data =1;

    public Producer(CircularBufferImpl circularBuffer) {
        this.circularBuffer = circularBuffer;
    }

    public void produceItem(){
        this.circularBuffer.addItem(data);
        System.out.println("Produce: " + data);
        data++;
    }

    @Override
    public void run() {
        IntStream.range(0, 4).forEach(e -> {
            while (this.circularBuffer.getCurrentBufferSize() == 0) {
                Thread.yield();
            }
            this.produceItem();
        });
    }
}
