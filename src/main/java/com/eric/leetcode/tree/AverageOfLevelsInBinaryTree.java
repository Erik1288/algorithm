package com.eric.leetcode.tree;

import com.eric.model.tree.TreeNode;

import java.util.*;

/**
 * 637. 二叉树的层平均值
 *
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 *
 * 示例 1:
 *
 * 输入:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 * 注意：
 *
 * 节点值的范围在32位有符号整数范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AverageOfLevelsInBinaryTree {
    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> result = new ArrayList<>();
            levelOrder(root, result);
            return result;
        }

        private void levelOrder(TreeNode root, List<Double> result) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            if (root != null) queue.add(root);

            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                long sum = 0;
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();
                    sum += node.val;

                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                result.add(sum * 1.0 / levelSize);
            }
        }
    }
}
