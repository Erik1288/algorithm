package com.eric.lock;

import java.util.concurrent.atomic.AtomicBoolean;

public class SpinLock {
    private AtomicBoolean locked = new AtomicBoolean(false);

    public SpinLock() {
    }

    public void lock() {
        while (!locked.compareAndSet(false, true)) {
        }
        return ;
    }

    public void unlock() {
        while (locked.compareAndSet(true, false)) {
        }
        return ;
    }
}
