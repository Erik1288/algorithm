package com.eric.leetcode.prefixsum;

import com.eric.util.TreeCodec;
import com.eric.model.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Eric
 * Date: 2020/2/3
 *
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSumIII {
    public static void main(String[] args) {
        int i = new Solution().pathSum(TreeCodec.deserialize("[1,-2,-3]"), -1);
//        int i = new Solution().pathSum(TreeCodec.deserialize("[1,2,-3,4]"), 0);
//        int i = new Solution().pathSum(TreeCodec.deserialize("[5,4,8,11,null,13,4,7,2,null,null,5,1]"), 22);
//        int i = new Solution().pathSum(TreeCodec.deserialize("[10,5,-3,3,2,null,11,3,-2,null,1]"), 8);
        System.out.println(i);
    }

    static class Solution {
        private int pathSum = 0;

        /**
         *
         * 初始化的时候，需要加入 prefixSum[0] = 1，因为当prefixSum == target时，也要算出现了一次。如果没有初始化，就漏掉了
         * @param root
         * @param sum
         * @return
         */
        public int pathSum(TreeNode root, int sum) {
            if (root == null) return 0;

            // key是前缀和, value是大小为key的前缀和出现的次数
            Map<Integer, Integer> prefixSum2Count = new HashMap<>();
            prefixSum2Count.put(0, 1);
            preOrderAndBacktrack(root, 0, sum, prefixSum2Count);
            return pathSum;
        }

        private void preOrderAndBacktrack(TreeNode root, int prefixSum, int target, Map<Integer, Integer> prefixSum2Count) {
            if (root == null) return ;

            /*###################*/
            prefixSum += root.val;

            // 判断有没有和为target的路径
            Integer count = prefixSum2Count.getOrDefault(prefixSum - target, 0);
            if (count > 0) {
                this.pathSum += count;
            }

            prefixSum2Count.put(prefixSum, prefixSum2Count.getOrDefault(prefixSum, 0) + 1);
            /*###################*/

            preOrderAndBacktrack(root.left, prefixSum, target, prefixSum2Count);
            preOrderAndBacktrack(root.right, prefixSum, target, prefixSum2Count);

            // 回溯，撤销递归前做的决定
            prefixSum2Count.put(prefixSum, prefixSum2Count.getOrDefault(prefixSum, 0) - 1);
        }
    }
}
