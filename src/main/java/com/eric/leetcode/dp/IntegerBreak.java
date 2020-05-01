package com.eric.leetcode.dp;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        // dp[n]为n的最大拆分乘积值
        // dp[n] = max((n-1)*dp[1], (n-2)*dp[2], (n-3)*dp[3] ... , 1*dp[n-1])
        // 里面好多重复的计算，看看怎么优化
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        // n为2和3的时候，它们的dp值比自己本身都要小
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = max(max, j * dp[i - j]);
            }
            dp[i] = max;
        }
        return dp[n];
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }
}
