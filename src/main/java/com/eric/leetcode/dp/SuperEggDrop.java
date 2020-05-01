package com.eric.leetcode.dp;

/**
 * User: Eric
 * Date: 2020/1/26
 *
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 *
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 *
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 *
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 *
 * 你的目标是确切地知道 F 的值是多少。
 *
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 *
 * 示例 1：
 *
 * 输入：K = 1, N = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
 * 如果它没碎，那么我们肯定知道 F = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
 * 示例 2：
 *
 * 输入：K = 2, N = 6
 * 输出：3
 * 示例 3：
 *
 * 输入：K = 3, N = 14
 * 输出：4
 *  
 *
 * 提示：
 *
 * 1 <= K <= 100
 * 1 <= N <= 10000
 * 在真实的面试中遇到过这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-egg-drop
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SuperEggDrop {
    public static void main(String[] args) {
        int i = new Solution().superEggDrop(3, 30);
        System.out.println(i);
    }

    static class Solution {
        public int superEggDrop(int K, int N) {
            return dp(K, N);
        }

        private int dp(int eggCount, int high) {
            if (eggCount == 1 || high <= 1) return high;

            int min = high;

            // 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
            for (int i = 1; i <= high; i ++) {
                // 在i层，鸡蛋碎了
                int case1Count = dp(eggCount - 1, i - 1);
                // 在i层，鸡蛋没碎
                int case2Count = dp(eggCount, high - i);

                int tMin = max(case1Count, case2Count);

                min = min(min, tMin + 1);
            }

            return min;
        }

        private int min(int a, int b) {
            return a < b ? a : b;
        }

        private int max(int a, int b) {
            return a > b ? a : b;
        }
    }
}
