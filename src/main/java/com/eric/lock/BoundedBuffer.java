package com.eric.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者/消费者 模型
 */
public class BoundedBuffer {
    private int cap;
    private int[] data;

    private int size = 0;
    private int put = 0;
    private int take = 0;

    public BoundedBuffer(int cap) {
        this.cap = cap;
        data = new int[cap];
    }

    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public void put(int t) {
        lock.lock();
        try {
//            if (size == cap) { // 这样写是错的,signalAll唤醒的是多个线程，而不是一个线程
            while (size == cap) {
                notFull.await();
            }
            size ++;
            data[put++ % cap] = t;
            notEmpty.signal(); // 这里唤醒某一个在条件队列等待的线程
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public int take() {
        lock.lock();
        try {
//            if (size == 0) { // 这样写是错的，因为signal会唤醒所有await在notEmpty上的线程。
            while (size == 0) {
                notEmpty.await();
            }
            size --;
            notFull.signal();
            return data[take++ % cap];
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
