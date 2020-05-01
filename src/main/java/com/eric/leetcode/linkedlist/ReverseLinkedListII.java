package com.eric.leetcode.linkedlist;

import com.eric.model.list.ListNode;
import com.eric.util.ListUtils;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Refer:
 * 扩宽了思路
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/bu-bu-chai-jie-ru-he-di-gui-di-fan-zhuan-lian-biao/
 */
public class ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode listNode = reverseBetweenR(ListUtils.createList(new int[]{1, 2, 3, 4, 5}), 2, 4);
        ListUtils.print(listNode);
    }

    public static ListNode reverseBetweenR(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseFirstNR(head, n);
        }

        head.next = reverseBetweenR(head.next, m - 1, n - 1);
        return head;
    }

    private static ListNode reverseFirstNR(ListNode head, int n) {
        if (n == 1) return head;
        ListNode newHead = reverseFirstNR(head.next, n - 1);
        ListNode rNext = head.next.next;
        head.next.next = head;
        head.next = rNext;
        return newHead;
    }

    /**
     * 1->2->3->4->5-Null
     * m = 2, n = 4
     *
     * reversePre = 1
     * reverseHead = 4
     * reverseTail = 2
     * reverseNext = 5
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode reversePre = dummy;
        ListNode cur = head;

        for (int i = 1; i < m; i++) {
            reversePre = cur;
            cur = cur.next;
        }

        ListNode reverseTail = cur;
        ListNode reverseHead;
        ListNode reverseNext = null;

        // 第一个指针不会变
        ListNode pre = cur;
        cur = cur.next;
        for (int i = m + 1; i <= n; i++) {
            reverseNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = reverseNext;
        }
        reverseHead = pre;

        // 重新拼接起来
        reversePre.next = reverseHead;
        reverseTail.next = reverseNext;

        return dummy.next;
    }
}
