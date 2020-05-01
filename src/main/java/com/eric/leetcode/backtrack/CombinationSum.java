package com.eric.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * User: Eric
 * Date: 2020/1/31
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum {
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().combinationSum(new int[]{}, 7);
        System.out.println(lists);
    }

    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> results = new ArrayList<>();
            backtrack(candidates, 0, 0, target, new LinkedList<>(), results);
            return results;
        }

        /**
         * @param candidates
         * @param beginIndex 用于去重
         * @param sum
         * @param target
         * @param result
         * @param results
         */
        private void backtrack(int[] candidates, int beginIndex/*用于结果去重*/, int sum, int target, LinkedList<Integer> result, List<List<Integer>> results) {
            if (sum >= target) {
                if (sum == target) results.add(new ArrayList<>(result));
                return ;
            }

            for (int i = beginIndex; i < candidates.length; i++) {
                result.add(candidates[i]);
                backtrack(candidates, i, sum + candidates[i], target, result, results);
                result.removeLast();
            }
        }
    }
}
