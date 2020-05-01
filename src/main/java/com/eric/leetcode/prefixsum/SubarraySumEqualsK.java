package com.eric.leetcode.prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Eric
 * Date: 2020/1/27
 *
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int i = new Solution().subarraySum(new int[]{1, 1, 1}, 2);
        System.out.println(i);
    }

    static class Solution {
        /**
         * 注意特殊情况的处理
         * 数组中全部都是0，k也是0： [0,0,0,0] k=0
         * @param nums
         * @param k
         * @return
         */
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> prefixSum2Count = new HashMap<>();
            prefixSum2Count.put(0, 1);
            int sum = 0;
            int cases = 0;

            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                int count = prefixSum2Count.getOrDefault(sum - k, 0);
                cases += count;
                prefixSum2Count.put(sum, prefixSum2Count.getOrDefault(sum, 0) + 1);
            }

            return cases;
        }
    }

}
