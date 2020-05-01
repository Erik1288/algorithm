package com.eric.lock.visibility;

import com.eric.lock.SpinLock;

public class MemoryVisibility {
//    private volatile static int sharedVariable = 0;
    private static int sharedVariable = 0;
    private static final int MAX = 10;

    private static Object obj = new Object();
    private static SpinLock lock = new SpinLock();

    public static void main(String[] args) {
        new Thread(() -> {
            int oldValue = sharedVariable;
//            lock.lock();
            synchronized (obj) {
                while (sharedVariable < MAX) {
//                    if (sharedVariable != oldValue) {
//                        System.out.println(Thread.currentThread().getName() + " watched the change : " + oldValue + "->" + sharedVariable);
//                        oldValue = sharedVariable;
//                    }

                    if (sharedVariable != oldValue) {
                        System.out.println(Thread.currentThread().getName() + " watched the change : " + oldValue + "->" + sharedVariable);
                        oldValue = sharedVariable;
                    }
                }
            }
//            lock.unlock();
        }, "t1").start();

        new Thread(() -> {
            int oldValue = sharedVariable;
            while (sharedVariable < MAX) {
                System.out.println(Thread.currentThread().getName() + " do the change : " + sharedVariable + "->" + (++oldValue));
                sharedVariable = oldValue;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2").start();

    }
}
