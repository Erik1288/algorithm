package com.eric.leetcode.array;

import java.util.Arrays;

/**
 * User: Eric
 * Date: 2020/2/7
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        int i = new Solution().threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        System.out.println(i);
    }

    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);

            int closestSum = 0;
            int diff = Integer.MAX_VALUE;
            for (int fixed = 0; fixed < nums.length; fixed++) {
                int left = fixed + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[fixed] + nums[left] + nums[right];
                    if (Math.abs(sum - target) < diff) {
                        diff = Math.abs(sum - target);
                        closestSum = sum;
                    }
                    if (sum > target) {
                        right --;
                    } else if (sum < target) {
                        left ++;
                    } else {
                        return target;
                    }
                }
            }
            return closestSum;
        }

    }
}
