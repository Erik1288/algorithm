package com.eric.leetcode.dp;

/**
 * User: Eric
 * Date: 2020/1/26
 *
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
    }

    static class Solution {
        /**
         *
         * dp[i][j]为 p[0:j]匹配到t[0:i]的结果
         * 1. p[j]为正常字符
         *    if (t[i] == p[j]), dp[i][j] = dp[i-1][j-1] //匹配1个，t和p都前进1个格子
         * 2. if (p[j] == '.'),  dp[i][j] = dp[i-1][j-1] //匹配1个，t和p都前进1个格子
         * 3. if (p[j] == '*')
         *    3.1 if (p[j] == '*' && t[i] != p[j-1])
         *                       dp[i][j] = dp[i][j-2] //匹配0个，t不前进，但t前进2个格子
         *    3.2 if (p[j] == '*' && (t[i] == p[j-1] || p[j-1] == '.'))
         *                       dp[i][j] = dp[i-1][j] //匹配多个，t前进1个格子，p不前进
         *                       dp[i][j] = dp[i][j-1] //匹配1个，t和p都前进1个格子，p处于中间状态
         *                       dp[i][j] = dp[i][j-2] //匹配0个，t不前进，但t前进2个格子
         *
         *
         * 理解或者记忆的关键，在于理解t和p需要各自前进几个格子
         * @param s
         * @param p
         * @return
         */
        public boolean isMatch(String s, String p) {
            return false;
        }
    }
}
