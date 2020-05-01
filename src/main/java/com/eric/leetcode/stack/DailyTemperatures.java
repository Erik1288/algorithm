package com.eric.leetcode.stack;

import java.util.Stack;

/**
 * User: Eric
 * Date: 2020/2/5
 *
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] ints = new Solution().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(ints);
    }

    static class Solution {
        public int[] dailyTemperatures(int[] arr) {
            // 到底这个单调栈的单调性怎么设计，需要白纸验算下。
            Stack<Integer/* index */> stack = new Stack<>();
            int[] result = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                    // 破坏单调性，需要弹出不符合要求的元素
                    Integer calculation = stack.pop();
                    result[calculation] = i - calculation;
                }

                stack.push(i);
            }
            return result;
        }
    }
}
