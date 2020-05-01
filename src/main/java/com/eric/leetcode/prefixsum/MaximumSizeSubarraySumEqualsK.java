package com.eric.leetcode.prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Eric
 * Date: 2020/1/27
 *
 * 给定一个数组 nums 和一个目标值 k，找到和等于 k 的最长子数组长度。如果不存在任意一个符合要求的子数组，则返回 0。
 *
 * 注意:
 *  nums 数组的总和是一定在 32 位有符号整数范围之内的。
 *
 * 示例 1:
 *
 * 输入: nums = [1, -1, 5, -2, 3], k = 3
 * 输出: 4
 * 解释: 子数组 [1, -1, 5, -2] 和等于 3，且长度最长。
 * 示例 2:
 *
 * 输入: nums = [-2, -1, 2, 1], k = 1
 * 输出: 2
 * 解释: 子数组 [-1, 2] 和等于 1，且长度最长。
 * 进阶:
 * 你能使时间复杂度在 O(n) 内完成此题吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-size-subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumSizeSubarraySumEqualsK {
    public static void main(String[] args) {
        // prefix sum = [1, 0, 5, 3, 6]
        int i = new Solution().maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3);
        System.out.println(i);
    }

    static class Solution {
        private int maxSize = -1;

        /**
         * 前缀和的思想比较简单，但需要很"有经验"的预处理，当前缀和==target的情况，需要补充一个前缀和=0的prefixSum
         * @param nums
         * @param k
         * @return
         */
        public int maxSubArrayLen(int[] nums, int k) {
            Map<Integer, Integer> prefixSum2Index = new HashMap<>();
            prefixSum2Index.put(0, -1);
            int sum = 0;

            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];

                if (prefixSum2Index.containsKey(sum - k)) maxSize = max(maxSize, i - prefixSum2Index.get(sum - k));
                // 如果有值，就保留下来，因为这个值肯定在左边，那么窗口一定是最大的
                if (!prefixSum2Index.containsKey(sum)) prefixSum2Index.put(sum, i);
            }

            return maxSize;
        }

        private int max(int a, int b) {
            return a > b ? a : b;
        }
    }
}
