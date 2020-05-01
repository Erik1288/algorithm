package com.eric.leetcode.trick;


import org.junit.Assert;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        Assert.assertEquals("aba", longestPalindrome("babad"));
        Assert.assertEquals("", longestPalindrome(""));

    }

    public static String longestPalindrome(String s) {
        if (s.length() == 0) return "";

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int l1 = symmetrical(s, i, i);
            int l2 = symmetrical(s, i, i + 1);
            int l = bigger(l1, l2);
            if (l > end - start) {
                // update
                start = i - (l - 1) / 2;
                end = i + l / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int symmetrical(String s, int l, int r) {
        while (l >= 0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)) {
            l --;
            r ++;
        }
        return r - l - 1; // 为什么-1
    }

    private static int bigger(int a, int b) {
        return a > b ? a : b;
    }
}
