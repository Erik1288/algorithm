package com.eric.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * User: Eric
 * Date: 2020/1/31
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSumII {
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(lists);
    }

    static class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> results = new ArrayList<>();
            Arrays.sort(candidates);
            backtrack(candidates, 0, 0, target, new LinkedList<>(), results);
            return results;
        }

        private void backtrack(int[] candidates, int beginIndex, int sum, int target, LinkedList<Integer> result, List<List<Integer>> results) {
            if (sum >= target) {
                if (sum == target) results.add(new ArrayList<>(result));
                return ;
            }

            for (int i = beginIndex; i < candidates.length; i++) {
                // 这部去重很关键
                if (i > beginIndex && candidates[i] == candidates[i - 1]) continue;

                result.add(candidates[i]);
                backtrack(candidates, i + 1, sum + candidates[i], target, result, results);
                result.removeLast();
            }
        }
    }
}
