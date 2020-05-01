package com.eric.leetcode.linkedlist;

import com.eric.model.list.ListNode;
import com.eric.util.ListUtils;

/**
 * 92. 反转链表 II 原题变种
 *
 * 反转前 n 的链表。请使用递归反转。
 *
 * 说明:
 * 1 ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, n = 3
 * 输出: 3->2->1->4->5->NULL
 *
 */
public class ReverseListFirstN {
    public static void main(String[] args) {
        ListNode head = ListUtils.createList(new int[]{1, 2, 3, 4, 5, 6});
        head = reverseListFirstN(head, 3);
        ListUtils.print(head);
    }

    public static ListNode reverseListFirstN(ListNode head, int n) {
        if (n == 1) return head;
        ListNode newHead = reverseListFirstN(head.next, n - 1);
        ListNode rNext = head.next.next;
        head.next.next = head;
        head.next = rNext;
        return newHead;
    }
}
