package com.eric.leetcode.doublepoint;

/**
 * User: Eric
 * Date: 2020/1/28
 */
class Solution {
    public void sortColors(int[] nums) {
        if (nums.length == 0) return ;

        int left = 0;
        int right = nums.length - 1;
        int cur = 0;

        // 维护一个区间 left <= cur <= right
        while (cur <= right) {
            if (nums[cur] == 0) {
                swap(nums, cur, left);
                left ++;
                // 需要维护left <= cur <= right
                if (cur < left) {
                    cur ++;
                }
            } else if (nums[cur] == 2) {
                swap(nums, cur, right);
                right --;
            } else {
                cur ++;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}