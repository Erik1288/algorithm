package com.eric.util;


import com.eric.model.list.ListNode;

public class ListUtils {
    public static ListNode createList(int[] nums) {
        ListNode head = null;
        ListNode pre = null;
        for (int num : nums) {
            ListNode listNode = new ListNode(num);
            if (pre != null) pre.next = listNode;
            if (head == null) head = listNode;
            pre = listNode;
        }

        pre.next = null;

        return head;
    }

    public static void print(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
