package com.eric.leetcode.stack;

import java.util.Stack;


/**
 * User: Eric
 * Date: 2020/1/15
 * <p>
 * <p>
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * <p>
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 * <p>
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 * <p>
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BasicCalculatorII {
    public static void main(String[] args) {
        int calculate = new Solution().calculate("3+2*2");
        System.out.println(calculate);
    }

    static class Solution {
        /**
         * 这种方式写非常优雅，但是有些技巧性在
         * 一定要拿个简单的例子在白纸验算下
         * Refer:
         * https://leetcode-cn.com/problems/basic-calculator-ii/comments/78521
         * @param s
         * @return
         */
        public int calculate(String s) {
            Stack<Integer> stack = new Stack<>();
            int result = 0;
            // 上一个操作符，用'+'来初始化
            char lastSign = '+';
            int number = 0;
            for (int i = 0; i < s.length(); i++) {
                // 获取多位数字
                if (isNumber(s.charAt(i))) {
                    number = number * 10 + (s.charAt(i) - '0');
                }
                // 这里不能else if开头
                if (isSign(s.charAt(i)) || i == s.length() - 1) {
                    // ############### 遇到 + - 不做计算 ###############
                    if (lastSign == '+') {
                        stack.push(number);
                    } else if (lastSign == '-') {
                        // 取反，化简成加法
                        stack.push(-number);
                    }
                    // ############### 遇到 * / 把上上个数字计算出来 #########
                    else if (lastSign == '*') {
                        stack.push(stack.pop() * number);
                    } else if (lastSign == '/') {
                        stack.push(stack.pop() / number);
                    }
                    // clear number
                    number = 0;
                    lastSign = s.charAt(i);
                }
            }

            // 最后在栈中剩下的，都是正常的加法运算，减法都被化简成了加法
            while (!stack.isEmpty()) {
                result += stack.pop();
            }
            return result;
        }

        private boolean isNumber(char c) {
            return Character.isDigit(c);
        }

        private boolean isSign(char c) {
            return c == '+' || c == '-' || c == '*' || c == '/';
        }
    }
}
