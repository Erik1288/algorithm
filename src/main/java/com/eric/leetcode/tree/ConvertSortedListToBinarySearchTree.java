package com.eric.leetcode.tree;

import com.eric.model.list.ListNode;
import com.eric.model.tree.TreeNode;
import com.eric.util.ListUtils;

/**
 *
 * 109. 有序链表转换二叉搜索树
 *
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {
        ListNode list = ListUtils.createList(new int[]{-10, -3, 0, 5, 9});
        TreeNode treeNode = new Solution().sortedListToBST(list);
    }

    /**
     * 这个写法不需要破坏原来的链表
     */
    static class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            return process(head, null);
        }

        private TreeNode process(ListNode left, ListNode right) {
            if (left == right) return null;

            ListNode middle = middle(left, right);
            TreeNode root = new TreeNode(middle.val);
            root.left = process(left, middle);
            root.right = process(middle.next, right);
            return root;
        }

        private ListNode middle(ListNode left, ListNode right) {
            ListNode slow = left;
            ListNode fast = left;

            while (!(fast == right || fast.next == right)) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
}
