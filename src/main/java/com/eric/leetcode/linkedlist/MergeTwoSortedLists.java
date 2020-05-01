package com.eric.leetcode.linkedlist;

import com.eric.model.list.ListNode;
import com.eric.util.ListUtils;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = ListUtils.createList(new int[]{1, 3, 11});
        ListNode l2 = ListUtils.createList(new int[]{2, 4, 6, 8});

        ListNode head = mergeTwoLists(l1, l2);
//        ListNode head = mergeRecusion(l1, l2);
        ListUtils.print(head);
    }

    public static ListNode mergeRecusion(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        else if (l1.val < l2.val) {
            l1.next = mergeRecusion(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeRecusion(l1, l2.next);
            return l2;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);

        ListNode c1 = l1;
        ListNode c2 = l2;

        ListNode prev = dummy;

        while (!(c1 == null && c2 == null)) {
            if (c1 == null) {
                prev.next = c2;
                break;
            } else if (c2 == null) {
                prev.next = c1;
                break;
            } else if (c1.val <= c2.val) {
                prev.next = c1;
                c1 = c1.next;
            } else if (c1.val > c2.val) {
                prev.next = c2;
                c2 = c2.next;
            }

            prev = prev.next;
        }

        return dummy.next;
    }
}
