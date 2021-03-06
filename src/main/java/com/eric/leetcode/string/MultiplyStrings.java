package com.eric.leetcode.string;

/**
 * User: Eric
 * Date: 2020/2/9
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        String multiply = new Solution().multiply("123", "0");
//        String multiply = new Solution().multiply("123", "456");
        System.out.println(multiply);
    }

    static class Solution {
        public String multiply(String num1, String num2) {
            String sum = "0";
            for (int i = num2.length() - 1; i >= 0; i--) {
                String n = multiply0to9(num1, num2.charAt(i) - '0');
                sum = sum(sum, "0".equals(n) ? "0" : n + nZero(num2.length() - 1 - i));
            }
            return sum;
        }

        private String nZero(int n) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                builder.append("0");
            }
            return builder.toString();
        }

        private String multiply0to9(String num, int m/* 0-9 */) {
            if (m == 0) return "0";

            StringBuilder builder = new StringBuilder();
            int carry = 0;
            for (int i = num.length() - 1; i >= 0; i--) {
                int a = num.charAt(i) - '0';
                int product = a * m;
                builder.append((product + carry) % 10);
                carry = (product + carry) / 10;
            }
            if (carry != 0) {
                builder.append(carry);
            }

            return builder.reverse().toString();
        }

        private String sum(String n1, String n2) {
            StringBuilder builder = new StringBuilder();

            int p1 = n1.length() - 1;
            int p2 = n2.length() - 1;

            int carry = 0;
            while (p1 >= 0 || p2 >= 0) {
                int num1 = (p1 < 0 ? 0 : n1.charAt(p1) - '0');
                int num2 = (p2 < 0 ? 0 : n2.charAt(p2) - '0');

                int sum = num1 + num2 + carry;
                builder.append(sum % 10);
                carry = sum / 10;

                p1 --; p2 --;
            }
            if (carry != 0) {
                builder.append(carry);
            }

            return builder.reverse().toString();
        }
    }
}
