package com.eric.leetcode.linkedlist;

import com.eric.model.list.ListNode;
import com.eric.util.ListUtils;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Refer：
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/javadi-gui-fang-fa-100-by-chadriy-imdgvs6udp/
 */
public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        ListNode listNode = reverseKGroup(ListUtils.createList(new int[]{1, 2, 3, 4, 5}), 3);
        listNode = reverseKGroup(ListUtils.createList(new int[]{1, 2, 3, 4, 5, 6, 7, 8}), 3);
        ListUtils.print(listNode);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;

        int kk = k;
        ListNode start = head;
        ListNode cur = head;
        ListNode end;

        while (kk > 1) {
            kk --;
            if (cur == null) break;
            cur = cur.next;
        }

        // 不足K个
        if (cur == null) return head;

        end = cur;
        ListNode newHead = reverse(start, end);
        ListNode tail = start;
        tail.next = reverseKGroup(tail.next, k);

        return newHead;
    }

    private static ListNode reverse(ListNode head, ListNode tail) {
        if (head == tail) return tail;
        reverse(head.next, tail);
        ListNode nextGroupStart = head.next.next;
        head.next.next = head;
        head.next = nextGroupStart;

        return tail;
    }
}
