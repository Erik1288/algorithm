package com.eric.leetcode.linkedlist;

import com.eric.model.list.ListNode;
import com.eric.util.ListUtils;

import java.util.Stack;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * Refer:
 * 看这篇题解的思路
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/bu-bu-chai-jie-ru-he-di-gui-di-fan-zhuan-lian-biao/
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode head = ListUtils.createList(new int[]{1, 2, 3, 4, 5, 6});
        head = reverseR(head);
        ListUtils.print(head);
    }

    // 递归
    public static ListNode reverseR(ListNode head) {
        // 返回最后一个结点
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseR(head.next);
        // 让自己的下一个指向自己
        head.next.next = head;
        /**
         *                        ┌──────┐
         *                        │      │
         *                        ▼      │
         * ┌───┐  ┌───┐  ┌───┐  ┌───┐  ┌───┐
         * │ 5 │─▶│ 4 │─▶│ 3 │─▶│ 2 │─▶│ 1 │
         * └───┘  └───┘  └───┘  └───┘  └───┘
         */
        head.next = null;

        return newHead;
    }

    public static ListNode reverseStack(ListNode head) {
        if (head == null) return null;

        Stack<ListNode> stack = new Stack();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        head = stack.peek();
        while (!stack.isEmpty()) {
            ListNode pop = stack.pop();
            ListNode peek = stack.isEmpty() ? null : stack.peek();
            pop.next = peek;
        }

        return head;
    }



    public static ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
