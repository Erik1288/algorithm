package com.eric.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * User: Eric
 * Date: 2020/1/31
 *
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSumIII {
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().combinationSum3(3, 9);
        System.out.println(lists);
    }

    static class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> results = new ArrayList<>();
            backtrack(k, n, 0, 1, new LinkedList<>(), results);
            return results;
        }

        private void backtrack(int k, int n, int sum, int index, LinkedList<Integer> result, List<List<Integer>> results) {
            if (sum >= n && result.size() == k) {
                if (sum == n) results.add(new ArrayList<>(result));
                return ;
            }

            for (int i = index; i <= 9; i++) {
                result.add(i);
                backtrack(k, n , sum + i, i + 1, result, results);
                result.removeLast();
            }
        }
    }
}
