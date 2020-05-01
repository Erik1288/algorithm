package com.eric.leetcode.stack;

import java.util.Stack;

/**
 * User: Eric
 * Date: 2020/2/5
 *
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NextGreaterElementII {
    /**
     * Refer:
     * https://leetcode-cn.com/problems/next-greater-element-ii/solution/dan-diao-zhan-jie-jue-next-greater-number-yi-lei-2/
     */
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int[] result = new int[nums.length];
            Stack<Integer> stack = new Stack<>();

            for (int i = 2 * nums.length - 1; i >= 0; i--) {
                // 破坏单调性，需要移除太小的元素
                while (!stack.isEmpty() && nums[i % nums.length] >= stack.peek()) {
                    stack.pop();
                }

                // 保证栈顶的元素是第一个比当前数字大的元素，依次是第二大，第三大
                // 注意是用了两个一样的数组模拟循环数组，所以这边的值是会有覆盖的
                result[i % nums.length] = stack.isEmpty() ? -1 : stack.peek();

                stack.push(nums[i % nums.length]);
            }

            return result;
        }
    }
}
