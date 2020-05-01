package com.eric.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * User: Eric
 * Date: 2020/2/1
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Combinations {
    public static void main(String[] args) {
        List<List<Integer>> combine = new Solution().combine(4, 2);
        System.out.println(combine);
    }

    static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> results = new ArrayList<>();
            if (k > n) return results;

            backtrack(n, k, 1, new LinkedList<>(), results);
            return results;
        }

        private void backtrack(int n, int k, int beginIndex, LinkedList<Integer> result, List<List<Integer>> results) {
            if (result.size() == k) {
                results.add(new ArrayList<>(result));
                return ;
            }

            for (int i = beginIndex; i <= n; i++) {
                result.add(i);
                backtrack(n, k, i + 1, result, results);
                result.removeLast();
            }
        }
    }
}
