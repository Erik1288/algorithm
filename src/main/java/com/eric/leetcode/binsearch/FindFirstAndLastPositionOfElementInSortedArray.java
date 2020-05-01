package com.eric.leetcode.binsearch;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] ints = new Solution().searchRange(new int[]{1}, 1);
        System.out.println(ints[0] + " " + ints[1]);
    }

    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            return new int[]{findLeftBound(nums, target), findRightBound(nums, target)};
        }

        // 在[left, right]闭区间搜索left边界
        private int findLeftBound(int[] nums, int target) {
            int left  = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (target > nums[mid]) {
                    left = mid + 1;
                } else if (target < nums[mid]) {
                    right = mid - 1;
                } else {
                    right = mid - 1;
                }
            }
            return (left <= nums.length - 1 && nums[left] == target) ? left : -1;
        }

        // 在[left, right]闭区间搜索right边界
        private int findRightBound(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (target > nums[mid]) {
                    left = mid + 1;
                } else if (target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return (right >= 0 && nums[right] == target) ? right : -1;
        }
    }
}