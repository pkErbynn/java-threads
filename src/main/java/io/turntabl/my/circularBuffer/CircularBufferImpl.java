package io.turntabl.my.circularBuffer;

import java.util.Arrays;

public class CircularBufferImpl {
    private Object lock = new Object();
    private volatile int[] bufferCapacity;
    private volatile int currentBufferSize;
    private volatile int head;
    private volatile int tail;

    public int getCurrentBufferSize() {
        return this.currentBufferSize;
    }

    public CircularBufferImpl(int setBufferSize) {
        this.bufferCapacity = new int[setBufferSize];
        this.head= -1;
        this.tail = -1;
        this.currentBufferSize = setBufferSize;
    }

    public void addItem(int num){
        synchronized (lock){

            if (isBufferFull()) {
                try {
                    throw new Exception("Queue full...no more item to add");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            tail = (tail + 1) % bufferCapacity.length;
            bufferCapacity[tail] = num;
            currentBufferSize++;
        }
    }

    public boolean isBufferFull() {
        if (currentBufferSize == bufferCapacity.length) {
            return true;
        }
        else return false;
    }

    public int removeItem() {
        synchronized (lock) {

            if (isBufferEmpty()) {
                try {
                    throw new Exception("Buffer empty...cannot remove item");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            int itemRemoved = bufferCapacity[tail];
            bufferCapacity[head]= 0;
            head = (head + 1) % bufferCapacity.length;
//        currentBufferSize--;
            return itemRemoved;
        }
    }

    private boolean isBufferEmpty() {
        return currentBufferSize == 0 ;
        }


    @Override
    public String toString() {
        return "CircularBufferImpl{" +
                "bufferCapacity=" + Arrays.toString(bufferCapacity) +
                ", currentBufferSize=" + currentBufferSize +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }

    public static void main(String[] args) throws InterruptedException {
        CircularBufferImpl  cbf = new CircularBufferImpl(5);
        Producer producer = new Producer(cbf);
        Consumer consumer = new Consumer(cbf);

        producer.start();
        Thread.sleep(2000);
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println("Circular buffer : " + cbf);

    }
}
