package com.eric.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 254. 因子的组合
 *
 * 整数可以被看作是其因子的乘积。
 *
 * 例如：
 *
 * 8 = 2 x 2 x 2;
 *   = 2 x 4.
 * 请实现一个函数，该函数接收一个整数 n 并返回该整数所有的因子组合。
 *
 * 注意：
 *
 * 你可以假定 n 为永远为正数。
 * 因子必须大于 1 并且小于 n。
 * 示例 1：
 *
 * 输入: 1
 * 输出: []
 * 示例 2：
 *
 * 输入: 37
 * 输出: []
 * 示例 3：
 *
 * 输入: 12
 * 输出:
 * [
 *   [2, 6],
 *   [2, 2, 3],
 *   [3, 4]
 * ]
 * 示例 4:
 *
 * 输入: 32
 * 输出:
 * [
 *   [2, 16],
 *   [2, 2, 8],
 *   [2, 2, 2, 4],
 *   [2, 2, 2, 2, 2],
 *   [2, 4, 4],
 *   [4, 8]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factor-combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FactorCombinations {
    public static void main(String[] args) {
        List<List<Integer>> factors = new Solution().getFactors(32);
        System.out.println(factors);
    }

    static class Solution {
        public List<List<Integer>> getFactors(int n) {
            List<List<Integer>> results = new ArrayList<>();
            List<Integer> result = new ArrayList<>();
            process(n, 2, result, results);
            return results;
        }

        private void process(int n, int processIndex, List<Integer> result, List<List<Integer>> results) {
            for (int i = processIndex; i * i <= n; i++) {
                if (n % i != 0) continue;
                int f = n / i;
                result.add(i);
                result.add(f);
                results.add(new ArrayList<>(result));
                result.remove(result.size() - 1); // 回溯拿走最后一个因子
                process(n / i, i, result, results);
                result.remove(result.size() - 1); // 回溯拿走第一个因子

            }
        }
    }
}
