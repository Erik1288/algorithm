package com.eric.leetcode.binsearch;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 * 你可以假设数组中不存在重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int min = new Solution().findMin(new int[]{3, 4, 5, 1, 2});
        System.out.println(min);
    }

    static class Solution {
        public int findMin(int[] nums) {
            int left = 0;
            int right = nums.length - 1;

            int min = Integer.MAX_VALUE;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[left] <= nums[mid] && nums[mid] <= nums[right]) {
                    // [left, right]整体有序
                    min = min(min, nums[left]);
                    break;
                } else if (nums[left] <= nums[mid]) {
                    // [left, mid]有序
                    min = min(min, nums[left]);
                    left = mid + 1;
                } else if (nums[mid] <= nums[right]) {
                    min = min(min, nums[mid]);
                    right = mid - 1;
                }
            }

            return min;
        }

        private int min(int a, int b) {
            return a < b ? a : b;
        }
    }
}
