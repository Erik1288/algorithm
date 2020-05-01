package com.eric.leetcode.tree;

import com.eric.util.TreeCodec;
import com.eric.model.tree.TreeNode;

import java.util.LinkedList;

/**
 * User: Eric
 * Date: 2020/2/2
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
//        TreeNode root = TreeCodec.deserialize("[10,5,15,null,null,6,20]");
        TreeNode root = TreeCodec.deserialize("[2,1,3]");
//        TreeNode root = TreeCodec.deserialize("[5,1,4,null,null,3,6]");
        System.out.println(new Solution().isValidBST(root));
    }

    /**
     * 对于二叉搜索树，中序遍历是严格递增的。
     */
    static class Solution {
        private boolean isValid = true;
        public boolean isValidBST(TreeNode root) {
            inorder(root, new LinkedList<>());
            return isValid;
        }

        private void inorder(TreeNode root, LinkedList<Integer> results) {
            if (root == null || !isValid) return;

            inorder(root.left, results);
            // 如果新遍历到的数字>上一个数字，那么说明是有效的。则，新遍历的数字<=上一个数字是无效的
            if (!results.isEmpty() && root.val <= results.getLast()) isValid = false;
            results.add(root.val);
            inorder(root.right, results);
        }
    }
}
