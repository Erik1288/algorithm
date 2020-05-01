package com.eric.leetcode.tree;

import com.eric.model.tree.TreeNode;
import com.eric.util.TreeCodec;

/**
 * User: Eric
 * Date: 2020/2/4
 *
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 例如：
 *
 * 输入: 二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConvertBstToGreaterTree {
    public static void main(String[] args) {
        TreeNode treeNode = new Solution().convertBST(TreeCodec.deserialize("[5,2,13,1,4]"));
        System.out.println(TreeCodec.serialize(treeNode));
    }

    static class Solution {
        private int sum;

        public TreeNode convertBST(TreeNode root) {
            antiInOrder(root);
            return root;
        }

        /**
         * 用中序遍历，函数不要传状态，容易混乱
         * @param root
         */
        private void antiInOrder(TreeNode root) {
            if (root == null) return ;

            antiInOrder(root.right);

            /*#######################*/
            root.val += this.sum;
            this.sum = root.val;
            /*#######################*/

            antiInOrder(root.left);
        }
    }
}
