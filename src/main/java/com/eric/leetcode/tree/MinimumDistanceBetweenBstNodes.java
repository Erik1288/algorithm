package com.eric.leetcode.tree;

import com.eric.model.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Eric
 * Date: 2020/2/4
 *
 * 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
 *
 * 示例：
 *
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树结点对象(TreeNode object)，而不是数组。
 *
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 *
 *           4
 *         /   \
 *       2      6
 *      / \
 *     1   3
 *
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 * 注意：
 *
 * 二叉树的大小范围在 2 到 100。
 * 二叉树总是有效的，每个节点的值都是整数，且不重复。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumDistanceBetweenBstNodes {
    class Solution {
        private int min = Integer.MAX_VALUE;
        public int minDiffInBST(TreeNode root) {
            inOrder(root, new ArrayList<>());
            return this.min;
        }

        private void inOrder(TreeNode root, List<Integer> results) {
            if (root == null) return ;

            inOrder(root.left, results);

            /*#################*/
            if (!results.isEmpty()) min = min(min, root.val - results.get(results.size() - 1));
            results.add(root.val);
            /*#################*/

            inOrder(root.right, results);
        }

        private int min(int a, int b) {
            return a < b ? a : b;
        }
    }
}
