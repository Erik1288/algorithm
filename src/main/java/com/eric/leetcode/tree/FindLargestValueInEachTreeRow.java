package com.eric.leetcode.tree;

import com.eric.model.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * User: Eric
 * Date: 2020/2/3
 *
 * 您需要在二叉树的每一行中找到最大的值。
 *
 * 示例：
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * 输出: [1, 3, 9]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindLargestValueInEachTreeRow {
    class Solution {
        public List<Integer> largestValues(TreeNode root) {
            TreeMap<Integer, Integer> level2LargestVal = new TreeMap<>();
            preOrder(root, 0, level2LargestVal);

            return new ArrayList(level2LargestVal.values());
        }

        private void preOrder(TreeNode root, int level, TreeMap<Integer, Integer> level2LargestVal) {
            if (root == null) return ;

            /*################################*/
            Integer val = level2LargestVal.getOrDefault(level, Integer.MIN_VALUE);
            level2LargestVal.put(level, max(val, root.val));
            /*################################*/

            preOrder(root.left, level + 1, level2LargestVal);
            preOrder(root.right, level + 1, level2LargestVal);
        }

        private int max(int a, int b) {
            return a > b ? a : b;
        }
    }
}
