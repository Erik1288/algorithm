package com.eric.leetcode.slidingwindow;

/**
 * User: Eric
 * Date: 2020/1/30
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 *
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int i = new Solution().minSubArrayLen(7, new int[]{2, 6, 7});
        System.out.println(i);
    }

    static class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            if (nums.length == 0) return 0;

            int left = 0;
            int min = Integer.MAX_VALUE;
            int sum = 0;
            for (int right = 0; right < nums.length; right++) {
                // 窗口内存无效，不够大，] 向右移动
                sum += nums[right];
                // 窗口有效了，需要缩减，[ 向左移动
                while (sum >= s) {
                    // snapshot，趁着有效，赶紧统计一把
                    min = min(min, right - left + 1);

                    sum -= nums[left];
                    left ++;
                }
            }

            return min == Integer.MAX_VALUE ? 0 : min;
        }

        private int min(int a, int b) {
            return a < b ? a : b;
        }
    }
}
