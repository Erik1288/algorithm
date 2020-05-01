package com.eric.leetcode.tree;

import com.eric.model.tree.TreeNode;
import com.eric.util.TreeCodec;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Eric
 * Date: 2020/2/4
 *
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 *
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 *
 * 示例 1:
 *
 * 输入:
 *
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 *
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 * 示例 2:
 *
 * 输入:
 *
 *           1
 *          /
 *         3
 *        / \
 *       5   3
 *
 * 输出: 2
 * 解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
 * 示例 3:
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        /
 *       5
 *
 * 输出: 2
 * 解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
 * 示例 4:
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        /     \
 *       5       9
 *      /         \
 *     6           7
 * 输出: 8
 * 解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
 * 注意: 答案在32位有符号整数的表示范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumWidthOfBinaryTree {
    public static void main(String[] args) {
        int i = new Solution().widthOfBinaryTree(TreeCodec.deserialize("[1,1,1,1,null,null,1,1,null,null,1]"));
//        int i = new Solution().widthOfBinaryTree(TreeCodec.deserialize("[1,3,2,5,3,null,9]"));
        System.out.println(i);
    }

    static class Solution {
        private int maxWidth = Integer.MIN_VALUE;

        public int widthOfBinaryTree(TreeNode root) {
            preOrder(root, 0, 1, new HashMap<>());
            return this.maxWidth;
        }

        private void preOrder(TreeNode root, int pos, int depth, Map<Integer, Integer> mostLeft) {
            if (root == null) return ;

            // 前序遍历，确保每一层最左边的先被访问到
            if (!mostLeft.containsKey(depth)) mostLeft.put(depth, pos);
            maxWidth = max(maxWidth, pos - mostLeft.get(depth) + 1);

            preOrder(root.left, 2 * pos + 1, depth + 1, mostLeft);
            preOrder(root.right, 2 * pos + 2, depth + 1, mostLeft);
        }

        private int max(int a, int b) {
            return a > b ? a : b;
        }
    }
}
