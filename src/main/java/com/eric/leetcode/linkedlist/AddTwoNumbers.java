package com.eric.leetcode.linkedlist;

import com.eric.model.list.ListNode;
import com.eric.util.ListUtils;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode listNode = addTwoNumbers(ListUtils.createList(new int[]{2, 4, 3}),
                ListUtils.createList(new int[]{5, 6}));
        ListUtils.print(listNode);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        ListNode dummyNode = new ListNode(-1);
        ListNode cur = dummyNode;

        boolean carry = false;

        while (cur1 != null || cur2 != null) {
            int n1 = (cur1 == null ? 0 : cur1.val);
            int n2 = (cur2 == null ? 0 : cur2.val);

            int n;
            if (carry) {
                n = n1 + n2 + 1;
            } else {
                n = n1 + n2;
            }

            if (n >= 10) {
                n = n - 10;
                carry = true;
            } else {
                carry = false;
            }

            cur.next = new ListNode(n);
            cur = cur.next;

            if (cur1 != null) cur1 = cur1.next;
            if (cur2 != null) cur2 = cur2.next;
        }

        if (carry) cur.next = new ListNode(1);

        return dummyNode.next;
    }
}
