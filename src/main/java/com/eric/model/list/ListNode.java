package com.eric.model.list;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int value) {
        this.val = value;
    }

    public ListNode(ListNode next) {
        this.next = next;
    }
}
