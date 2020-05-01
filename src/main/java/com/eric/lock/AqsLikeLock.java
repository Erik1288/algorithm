package com.eric.lock;

import com.eric.util.UnsafeUtils;
import sun.misc.Unsafe;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.LockSupport;

public class AqsLikeLock {
    private volatile int state = 0;
    private ConcurrentLinkedQueue<Thread> waiters = new ConcurrentLinkedQueue();
    private Thread owner = null;
    private static Unsafe unsafe = UnsafeUtils.getUnsafe();
    private static long stateOffset;
    static {
        try {
            stateOffset = unsafe.objectFieldOffset(AqsLikeLock.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            throw new Error(e);
        }
    }

    private int getState() {
        return state;
    }

    public void unlock() {
        state -= 1;
        // 唤醒等待的线程
        LockSupport.unpark(waiters.poll());
    }

    public void lock() {
        for (; ; ) {
            Thread current = Thread.currentThread();
            int state = getState();
            if (state != 0) {
                // fail, park
                waiters.add(current);
                LockSupport.park();
            }
            if (unsafe.compareAndSwapInt(this, stateOffset, 0, 1)) {
                // success
                owner = current;
                break;
            }
        }
    }

    public void lockHold() {
        if (!Thread.currentThread().equals(owner)) throw new Error("not hold");
    }

    public static void main(String[] args) {
        AqsLikeLock lock = new AqsLikeLock();

        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    lock.lock();
                    System.out.println(finalI);
                } finally {
                    lock.unlock();
                }
            }).start();

        }
    }
}
