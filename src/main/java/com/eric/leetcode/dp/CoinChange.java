package com.eric.leetcode.dp;

/**
 * 322. 零钱兑换
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CoinChange {
    public static void main(String[] args) {
//        int i = new Solution().coinChange(new int[]{1, 2, 5}, 11);
        int i = new Solution().coinChange(new int[]{186,419,83,408}, 6249);

        System.out.println(i);
    }

    /**
     * 第一眼做的时候就想到了贪心，中招了。。。
     * 反例参考: https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-suan-fa-si-xiang-by-hikes/
     * [1，5，11] target = 15
     * 如果用贪心思想，结果为 11 + 1 + 1 + 1 + 1 共5枚硬币
     * 但是正解是 5 + 5 + 5 共3枚硬币
     *
     * 背包问题
     * 0/1背包问题
     * 完全背包问题
     * 
     * 
     * 注意与 https://leetcode-cn.com/problems/combination-sum/ 的区别，组合总和和零钱兑换的题干非常像，但是，零钱兑换需要求的
     * 是最少的硬币数量，而组合总数求的是所有的不重复的枚举，前者应该用DP来做，后者必须是用回溯来做。
     */
    static class Solution {
        public int coinChange(int[] coins, int amount) {
            /**
             * 设dp[n]为amount为n时，凑齐amount需要的最少的硬币数量，硬币面值为：1，2，5
             * if n == 0 : dp[n] = 0;
             * if n > 0 dp[n] = min(dp[n - 1] + 1, dp[n - 2] + 1, dp[n - 5] + 1);
             *
             * 问题类似于斐波那契或者爬楼梯
             * 只是爬楼梯的dp[n]是指方式总数，所以是 dp[n-] + dp[n - 2]，即最后一步是跨一阶还是二阶
             * 而本题dp[n]是指最少的硬币的数量，不管上一步到这一步是+1，+2还是+5，硬币的数量都会+1。
             *
             * 知道了这个通项公式之后，本题的求解就变得非常简单了，本质上就是算下面这个式子
             *
             * dp[n] = min(dp[n - 1] + 1, dp[n - 2] + 1, dp[n - 5] + 1)
             */
            int[] dp = new int[amount + 1];
            dp[0] = 0;

            for (int i = 1; i <= amount; i++) {
                int min = Integer.MAX_VALUE - 1; // 防止+1后越界
                for (int coin : coins) {
                    if (i >= coin) { // 需要凑齐的数额 >= 当前的硬币面额
                        min = min(min, dp[i - coin] + 1);
                    }
                }
                dp[i] = min;
            }

            return dp[amount] == Integer.MAX_VALUE - 1 ? -1: dp[amount];
        }

        private int min(int a, int b) {
            return a < b ? a : b;
        }

    }
}
