package com.eric.leetcode.array;

/**
 *
 * 11. 盛最多水的容器
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ContainerWithMostWater {
    /**
     *
     */
    class SolutionOne {
        public int maxArea(int[] height) {
            int maxArea = 0;
            for (int i = 0; i < height.length; i++) {
                for (int j = i + 1; j < height.length; j++) {
                    maxArea = max(maxArea, min(height[i], height[j]) * (j - i));
                }
            }
            return maxArea;
        }

        private int max(int a, int b) {
            return a > b ? a : b;
        }

        private int min(int a, int b) {
            return a < b ? a : b;
        }
    }

    /**
     * Refer:
     * https://leetcode-cn.com/problems/container-with-most-water/solution/container-with-most-water-shuang-zhi-zhen-fa-yi-do/
     */
    class Solution {
        public int maxArea(int[] height) {
            int maxArea = 0;
            int left = 0;
            int right = height.length - 1;

            while (left < right) {
                maxArea = max(maxArea, (right - left) * min(height[left], height[right]));
                /**
                 * 移动原理
                 * 不管是left往右移动，或者是right往左移动，right - left 的值是一样的，这个层面先不考虑。
                 * 那到底是 left往右移动 还是 right往左移动?
                 * 如果left是小的那边，如果 left右移，那么面积可能变大，也可能不变；如果 right左移，那么面积可能不变，也可能变小。
                 */
                if (height[left] <= height[right]) left++;
                else right--;
            }
            return maxArea;
        }

        private int max(int a, int b) {
            return a > b ? a : b;

        }

        private int min(int a, int b) {
            return a < b ? a : b;
        }
    }
}