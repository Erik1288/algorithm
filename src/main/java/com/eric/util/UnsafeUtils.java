package com.eric.util;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeUtils {
    private static Unsafe instance;
    static {
        try {
            Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
            unsafeField.setAccessible(true);
            instance = (Unsafe) unsafeField.get(null);
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public static Unsafe getUnsafe() {
        return instance;
    }
}
