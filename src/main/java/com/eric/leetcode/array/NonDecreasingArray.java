package com.eric.leetcode.array;

/**
 * 给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。
 *
 * 示例 1:
 *
 * 输入: [4,2,3]
 * 输出: True
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 *
 * 输入: [4,2,1]
 * 输出: False
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 * 说明:  n 的范围为 [1, 10,000]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NonDecreasingArray {
    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{1, 3, 2, 5, 6}));
        System.out.println(checkPossibility(new int[]{1, 3, 7, 5, 6}));
        System.out.println(checkPossibility(new int[]{1, 3, 7, 5, 4}));
    }

    public static boolean checkPossibility(int[] nums) {
        /**
         * 数组边上的任意数字都是可以随意更改的
         *
         * case 1: n1 < n2 < n3 不需要改
         * case 2: n1 > n2 > n3 无力回天
         * case 3: n1 < n2 > n3 可以改
         * case 4: n1 > n2 < n3 可以改
         */

        int case3 = 0;
        int case4 = 0;
        int de = 0;
        int last = Integer.MIN_VALUE;

        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (valid(i - 1, size) && valid(i + 1, size) && nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                case3 ++;
            }

            if (valid(i - 1, size) && valid(i + 1, size) && nums[i - 1] > nums[i] && nums[i] > nums[i + 1]) {
                case4 ++;
            }

            if (nums[i] < last) de ++;
            last = nums[i];
        }

        if (case3 <= 1 && case4 <= 1 && de <= 1) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean valid(int i, int size) {
        return i >= 0 && i <= size - 1;
    }
}
