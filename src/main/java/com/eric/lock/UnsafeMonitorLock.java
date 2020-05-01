package com.eric.lock;

import com.eric.util.UnsafeUtils;
import sun.misc.Unsafe;

public class UnsafeMonitorLock {
    private static Unsafe unsafe = UnsafeUtils.getUnsafe();
    private Object monitor = new Object();

    public void lock() {
        unsafe.monitorEnter(monitor);
    }

    public void unlock() {
        unsafe.monitorExit(monitor);
    }
}
