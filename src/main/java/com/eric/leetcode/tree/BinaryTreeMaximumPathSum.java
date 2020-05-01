package com.eric.leetcode.tree;

import com.eric.model.tree.TreeNode;
import com.eric.util.TreeCodec;

/**
 * User: Eric
 * Date: 2020/2/8
 *
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 * 示例 2:
 *
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        int i = new Solution().maxPathSum(TreeCodec.deserialize("[1,2,3]"));
        System.out.println(i);
    }

    /**
     * Refer:
     * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/quan-ju-bian-liang-by-powcai/
     */
    static class Solution {
        private int maxPath = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            postOrder(root);
            return this.maxPath;
        }

        /**
         * 自底向上的递归，用后续遍历法
         * @param root
         * @return
         */
        private int postOrder(TreeNode root) {
            if (root == null) return 0;
            // 从低向上，left分支的最大值，肯定是>=0的，因为如果有小于0的分支，会被抛弃
            int maxLeftFromBottom = postOrder(root.left);
            // 从底向上，right分支的最大值，肯定是>=0的，因为如果有小于0的分支，会被抛弃
            int maxRightFromBottom = postOrder(root.right);

            // 那么遍历到当前节点，最大值有两种情况
            // 1. 以当前节点为连接点，加上左右分支的最大值
            // 2. 左分支或者右分支的最大值，并且返回给上层
            // 经过简单分析，case1是肯定大于case2的
            // 举例 : 20 + 15 + 7 >= 20 + max(15, 7)
            //   20
            //  /  \
            // 15   7
            this.maxPath = max(this.maxPath, root.val + maxLeftFromBottom + maxRightFromBottom);
            // 但是返回给上一层的，必须是case2的情况，也就是说，需要给左分支或者右分支中大的那个返回给上层
            int sumFromBottom = root.val + max(maxLeftFromBottom, maxRightFromBottom);
            return sumFromBottom < 0 ? 0 : sumFromBottom; // 如果小于0，需要抛弃掉，类似于这个序列的元素，我都不取，否则只会拖后腿
        }

        private int max(int a, int b) {
            return a > b ? a : b;
        }
    }
}
