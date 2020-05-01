package com.eric.leetcode.stack;

import java.util.Stack;

/**
 * User: Eric
 * Date: 2020/2/5
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int i = new Solution().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        System.out.println(i);
    }
    /**
     * Refer:
     * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhao-liang-bian-di-yi-ge-xiao-yu-ta-de-zhi-by-powc/
     *
     * 最最妙的就是在heights的前后加上两个0的预处理，能够保证一次遍历之后，栈里面的元素全部弹出。
     */
    static class Solution {
        /**
         * 最后计算的顺序是 2 -> 6 -> 5 -> 3 -> 2 -> 1，可以在纸上演算下
         *
         * 预处理后为
         * [0,2,1,5,6,2,3,0]
         *
         * 1.遍历到0
         * 栈中加入0
         *
         * |0|
         *
         * 2.遍历到2
         * 栈中加入2
         * | 2|
         * | 0|
         *
         * 3.遍历到1
         * 1小于栈顶的2，破坏单调性
         * 将2弹出，这时正好可以计算2这个节点的面积，right就是当前的1，left就是弹出2后的0
         *
         * | 1|
         * | 0|
         *
         * 4.遍历到5
         *
         * | 5|
         * | 1|
         * | 0|
         *
         * 5.遍历到6
         *
         * | 6|
         * | 5|
         * | 1|
         * | 0|
         *
         * 6.遍历到2
         * 2小于栈顶的6，破坏单调性
         * 将6弹出，计算6的面积
         *
         * | 5|
         * | 1|
         * | 0|
         *
         * 但是2还是小于5，继续弹出5，计算5的面试
         *
         * | 2|
         * | 1|
         * | 0|
         *
         * 7.遍历到3
         *
         * | 3|
         * | 2|
         * | 1|
         * | 0|
         *
         * 8.遍历到0
         * 0小于栈顶的3,
         * 弹出3，计算3的面积
         * 弹出2，计算2的面积
         * 弹出1，计算1的面积
         *
         *
         * @param heights
         * @return
         */
        public int largestRectangleArea(int[] heights) {
            int[] zeroHeightsZero = new int[heights.length + 2];
            for (int i = 1; i < zeroHeightsZero.length - 1; i++) {
                zeroHeightsZero[i] = heights[i - 1];
            }

            int maxArea = 0;
            Stack<Integer/*index*/> stack = new Stack<>();

            int length = zeroHeightsZero.length;
            for (int i = 0; i < length; i++) {
                // 找到第一个破坏单调性的
                while (!stack.isEmpty() && zeroHeightsZero[i] < zeroHeightsZero[stack.peek()]) {
                    // 既然后一个破坏了单调性，那么这个值就是上一个值右边第一个小于该值的数字，正好计算它的面积
                    Integer indexOfCalculation = stack.pop();
                    maxArea = max(zeroHeightsZero[indexOfCalculation] * (i - stack.peek() - 1), maxArea);
                }

                // 弹出了破坏单调性的数字，那么加入当前数字就可以了
                stack.push(i);
            }

            return maxArea;
        }

        private int max(int a, int b) {
            return a > b ? a : b;
        }
    }
}
