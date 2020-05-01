package com.eric.lock;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {
    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                lock1.lock();
                Thread.sleep(1000);
                lock2.lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock2.unlock();
                lock1.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                lock2.lock();
                Thread.sleep(1000);
                lock1.lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }).start();
    }
}
