package com.eric.leetcode.string;

/**
 * User: Eric
 * Date: 2020/2/9
 *
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 注意：
 *
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddStrings {
    public static void main(String[] args) {
        String s = new Solution().addStrings("99", "9");
        System.out.println(s);
    }

    static class Solution {
        public String addStrings(String n1, String n2) {
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
