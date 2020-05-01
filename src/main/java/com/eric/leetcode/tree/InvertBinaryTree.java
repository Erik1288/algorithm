package com.eric.leetcode.tree;

import com.eric.model.tree.TreeNode;

/**
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 *
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InvertBinaryTree {
    public static void main(String[] args) {

    }

    /**
     * Refer: https://leetcode-cn.com/problems/invert-binary-tree/solution/qian-zhong-hou-bian-li-by-vailing/
     */
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            preorder(root);
            return root;
        }

        /**
         * 需要对节点进行处理的，一定要用pre-order遍历
         * @param root
         */
        private void preorder(TreeNode root) {
            if (root == null) return ;

            /*######访问#######*/
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.right = left;
            root.left = right;
            /*######访问#######*/

            /**
             * 严格意义上，这里这么写
             * preorder(root.left);
             * preorder(root.right);
             *
             * 但这么写逻辑也没有问题
             */
            preorder(left);
            preorder(right);
        }
    }
}
