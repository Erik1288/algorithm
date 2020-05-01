package com.eric.leetcode.dp;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumSubarray {
    public static void main(String[] args) {

    }

    public static int maxSubArray(int[] nums) {
        int sc = 0; // 当前有效子序和
        int mg = 0; // 全局最大

        boolean no = true; // 只有负数
        int nm = Integer.MIN_VALUE; // 负数最大值

        for (int i = 0; i < nums.length; i++) {
            sc = max(sc + nums[i], 0);
            mg = max(mg, sc);

            if (no) nm = max(nm, nums[i]);
            if (nums[i] > 0) no = false;
        }

        return no ? nm : mg;
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

}
