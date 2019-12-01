package io.turntabl.my.circularBuffer.circularbuffer;

import java.util.stream.IntStream;

public class Producer extends Thread {
    CircularBuffer buffer;
    private int data = 1;

    public Producer(CircularBuffer buffer) {
        this.buffer = buffer;
    }

    private void produceElement() {
        this.buffer.insertElement(data);
        System.out.println("Producer: " + data);
        data++;

    }

    public void run() {
        IntStream.range(0, 20).forEach(i -> {
            while (this.buffer.getSize() == 0) {
                Thread.yield();
            }
            this.produceElement();
        });
    }
}
