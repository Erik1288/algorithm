package com.eric.leetcode.linkedlist;

import com.eric.model.list.ListNode;
import com.eric.util.ListUtils;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并K个排序链表
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        ListNode list1 = ListUtils.createList(new int[]{1, 4, 5});
        ListNode list2 = ListUtils.createList(new int[]{1, 3, 4});
        ListNode list3 = ListUtils.createList(new int[]{2,6});
        lists[0] = list1;
        lists[1] = list2;
        lists[2] = list3;

        ListNode listNode = new SolutionOne().mergeKLists(lists);
//        ListNode listNode = new SolutionOne().mergeKLists(lists);
        ListUtils.print(listNode);
    }

    /**
     * 用一个大小为lists.length的MinHeap来辅助合并
     */
    static class SolutionOne {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null) return null;
            if (lists.length == 0) return null;
            if (lists.length == 1) return lists[0];

            ListNode dummy = new ListNode(-1);
            ListNode prev = dummy;

            // minHeap中保存每一个链表中（只要链表没有结束），处于合并位置的最小值。
            PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val - o2.val;
                }
            });
            for (ListNode head: lists) {
                if (head != null) minHeap.add(head);
            }

            while (!minHeap.isEmpty()) {
                ListNode minNode = minHeap.poll();
                if (minNode.next != null) minHeap.add(minNode.next);
                prev.next = minNode;

                prev = prev.next;
            }

            return dummy.next;
        }
    }

    /**
     * 比较土的办法，合并K个链表，可以从合并两个链表开始，合并后结果再和另外的进行合并
     */
    static class SolutionTwo {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null) return null;
            if (lists.length == 0) return null;
            if (lists.length == 1) return lists[0];

            ListNode head = lists[0];
            for (int i = 1; i < lists.length; i++) {
                head = merge(head, lists[i]);
            }
            return head;
        }

        private ListNode merge(ListNode head1, ListNode head2) {
            ListNode dummy = new ListNode(-1);

            ListNode c1 = head1;
            ListNode c2 = head2;

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
}
