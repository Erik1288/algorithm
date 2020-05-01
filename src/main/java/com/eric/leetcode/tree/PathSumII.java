package com.eric.leetcode.tree;

import com.eric.model.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * User: Eric
 * Date: 2020/2/2
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSumII {
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> results = new ArrayList<>();
            preOrderAndBacktrack(root, sum, new LinkedList<>(), results);
            return results;
        }

        private void preOrderAndBacktrack(TreeNode root, int sum, LinkedList<Integer> result, List<List<Integer>> results) {
            if (root == null) return ;

            sum -= root.val;
            result.add(root.val);
            // is leaf
            if (root.left == null && root.right == null && sum == 0) {
                results.add(new ArrayList<>(result));
            }

            preOrderAndBacktrack(root.left, sum, result, results);
            preOrderAndBacktrack(root.right, sum, result, results);

            result.removeLast();
        }
    }
}
