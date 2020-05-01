package com.eric.leetcode.array;

/**
 * 31. 下一个排列
 *
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] ints = {1, 3, 2};
        new Solution().nextPermutation(ints);
        System.out.println(ints);
    }

    static class Solution {
        public void nextPermutation(int[] nums) {
            int i = nums.length - 1;
            while (i > 0 && nums[i] <= nums[i - 1]) {
                i --;
            }
            if (i == 0) {
                reverse(nums, 0, nums.length - 1);
                return ;
            }

            int p = i - 1;
            int q = p + 1;
            while (q <= nums.length - 1 && nums[p] < nums[q]) {
                q ++;
            }
            swap(nums, p, q - 1);
            reverse(nums, p + 1, nums.length - 1);
        }

        private void reverse(int[] nums, int l, int r) {
            while (l < r) {
                swap(nums, l++, r--);
            }
        }

        private void swap(int[] nums, int a, int b) {
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }


    }
}
