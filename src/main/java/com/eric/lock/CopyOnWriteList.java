package com.eric.lock;

import java.util.ArrayList;
import java.util.List;

class CopyOnWriteList {
    private volatile List<Integer> list;
    private Object monitor = new Object();

    public CopyOnWriteList() {
        list = new ArrayList<>();
    }

    public void put(Integer i) {
        synchronized (monitor) {
            List<Integer> _list = new ArrayList<>(list);
            _list.add(i);

            list = _list;
        }
    }

    public Integer get(int i) {
        return list.get(i);
    }
}
