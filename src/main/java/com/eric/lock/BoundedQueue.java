package com.eric.lock;

import java.util.LinkedList;
import java.util.List;

public class BoundedQueue {
    private int cap;
    private LinkedList<Integer> queue;

    public BoundedQueue(int cap) {
        this.cap = cap;
        this.queue = new LinkedList<>();
    }

    public void put(Integer i) throws InterruptedException {
        synchronized (queue) {
            while (queue.size() == cap) {
                queue.wait();
            }

            queue.add(i);
            queue.notify();
        }
    }

    public Integer take() throws InterruptedException {
        synchronized (queue) {
            while (queue.size() == 0) {
                queue.wait();
            }

            queue.notify();
            return queue.getLast();
        }
    }
}
