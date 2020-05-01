package com.eric.leetcode.tree;

import com.eric.util.TreeCodec;
import com.eric.model.tree.TreeNode;

/**
 * User: Eric
 * Date: 2020/2/2
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = TreeCodec.deserialize("[1,2,2,3,3,null,null,4,4]");
//        TreeNode root = TreeCodec.deserialize("[3,9,20,null,null,15,7]");
        boolean balanced = new Solution().isBalanced(root);
    }

    static class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;

            int left = depth(root.left);
            int right = depth(root.right);

            return (Math.abs(left - right) <= 1) && isBalanced(root.left) && isBalanced(root.right);
        }

        private int depth(TreeNode root) {
            if (root == null) return 0;
            return max(depth(root.left), depth(root.right)) + 1;
        }

        private int max(int a, int b) {
            return a > b ? a : b;
        }
    }
}
