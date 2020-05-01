package com.eric.leetcode.tree;

import com.eric.model.tree.TreeNode;

/**
 * User: Eric
 * Date: 2020/2/4
 *
 *
 */
public class LowestCommonAncestorOfABinarySearchTree {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            } else if (root == p) {
                return p;
            } else if (root == q) {
                return q;
            }

            TreeNode leftMaybePorQ = lowestCommonAncestor(root.left, p, q);
            TreeNode rightMaybePorQ = lowestCommonAncestor(root.right, p, q);

            /* #################### */
            // 这边的遍历方式为postOrder，所以根节点不会先被访问，所以查找到的祖先一定是最近的
            if (leftMaybePorQ != null && rightMaybePorQ != null) {
                return root;
            }
            /* #################### */

            return leftMaybePorQ == null ? rightMaybePorQ : leftMaybePorQ;
        }
    }
}
