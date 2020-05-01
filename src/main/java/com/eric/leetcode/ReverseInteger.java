package com.eric.leetcode;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(mySqrt(1));
    }
    // 这个题目是有坑的
    public static double mySqrt(int x) {
        double l = 0;
        double r = x;
        double m = (l + r) / 2.0;
        while (Math.abs(m * m - x) > 0.000000001) {
            if (m * m > x) r = m; // 太大了
            else if (m * m < x) l = m; // 太小了
            else break;

            m = (l + r) / 2.0;
        }
        return m;
    }
}
