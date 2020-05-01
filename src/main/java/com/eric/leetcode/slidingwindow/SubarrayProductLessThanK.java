package com.eric.leetcode.slidingwindow;

/**
 * User: Eric
 * Date: 2020/2/6
 *
 *
 */
public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        new Solution().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100);
    }

    static class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int left = 0;
            int product = 1;
            int cases = 0;
            for (int right = 0; right < nums.length; right++) {
                product *= nums[right];
                // 窗口无效了，和一般的滑动窗口有一点点区别
                while (product >= k) {
                    product /= nums[left];
                    left ++;
                }
                // 又有效了，统计一波
                cases += (right - left + 1);
            }

            return cases;
        }
    }
}
