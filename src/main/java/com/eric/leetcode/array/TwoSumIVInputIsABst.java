package com.eric.leetcode.array;

import com.eric.model.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Eric
 * Date: 2020/2/7
 *
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 案例 1:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * 输出: True
 *  
 *
 * 案例 2:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSumIVInputIsABst {
    class Solution {
        public boolean findTarget(TreeNode root, int k) {
            List<Integer> nums = new ArrayList<>();
            inorder(root, nums);

            int left = 0;
            int right = nums.size() - 1;

            while (left < right) { // left = right 就成了一个数字了，所以不能取
                int sum = nums.get(left) + nums.get(right);
                if (sum < k) {
                    left ++;
                } else if (sum > k) {
                    right --;
                } else {
                    return true;
                }
            }

            return false;
        }

        private void inorder(TreeNode root, List<Integer> nums) {
            if (root == null) return ;
            inorder(root.left, nums);
            nums.add(root.val);
            inorder(root.right, nums);
        }
    }
}
