package com.eric.leetcode.stack;

import java.util.Stack;

/**
 * User: Eric
 * Date: 2020/2/6
 *
 * 根据逆波兰表示法，求表达式的值。
 *
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 说明：
 *
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例 1：
 *
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * 示例 2：
 *
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 * 示例 3：
 *
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        int i = new Solution().evalRPN(new String[]{"2", "1", "+", "3", "*"});
        int i1 = new Solution().evalRPN(new String[]{"4", "13", "5", "/", "+"});
        System.out.println(i1);
    }

    static class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();

            for (String s : tokens) {
                // 遇到操作符时，从栈里弹出操作符需要的数字个数，进行计算，结果放入栈中
                if ("+".equals(s)) {
                    stack.push(stack.pop() + stack.pop());
                } else if ("-".equals(s)) {
                    Integer nums1 = stack.pop();
                    Integer nums2 = stack.pop();
                    stack.push(nums2 - nums1);
                } else if ("*".equals(s)) {
                    stack.push(stack.pop() * stack.pop());
                } else if ("/".equals(s)) {
                    Integer nums1 = stack.pop();
                    Integer nums2 = stack.pop();
                    stack.push(nums2 / nums1);
                } else {
                    // 是普通的数字，直接入栈
                    stack.push(Integer.valueOf(s));
                }
            }

            return stack.pop();
        }
    }
}
