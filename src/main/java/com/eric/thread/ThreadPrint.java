package com.eric.thread;

import sun.nio.ch.KQueueSelectorProvider;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPrint {
    static Object monitor = new Object();
    static volatile int num = 0;

    public static void main(String[] args) {
        printTo100(100);
    }

    public static void printTo100(int threadNum) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < threadNum; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            synchronized (monitor) {
                                monitor.notify();
                                if (num <= 100) {
                                    System.out.println(Thread.currentThread().getName() + " " + num++);
                                } else {
                                    break;
                                }
                                monitor.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, "t-" + i);
            threads.add(thread);
            thread.start();
        }

    }

}
