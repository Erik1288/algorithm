package com.eric.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * User: Eric
 * Date: 2020/2/1
 *
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubsetsII {
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().subsetsWithDup(new int[]{1, 2, 2});
        System.out.println(lists);
    }

    static class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> results = new ArrayList<>();
            Arrays.sort(nums);
            backtrack(nums, 0, new LinkedList<>(), results);
            return results;
        }

        private void backtrack(int[] nums, int beginIndex, LinkedList<Integer> result, List<List<Integer>> results) {
            results.add(new ArrayList<>(result));

            for (int i = beginIndex; i < nums.length; i++) {
                if (i > beginIndex && nums[i] == nums[i - 1]) continue;
                result.add(nums[i]);
                backtrack(nums, i + 1, result, results);
                result.removeLast();
            }
        }
    }
}
