package com.eric.lock;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ReadWriteLock {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap();
        map.put("a", "a");
        map.get("a");

        map.size();
    }
}
