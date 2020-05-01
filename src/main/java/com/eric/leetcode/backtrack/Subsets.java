package com.eric.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Subsets {
    public static void main(String[] args) {
        List<List<Integer>> subsets = new Solution().subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }


    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> results = new ArrayList<>();
            backtrack(nums, 0, new LinkedList<>(), results);
            return results;
        }

        private void backtrack(int[] nums, int beginIndex, LinkedList<Integer> result, List<List<Integer>> results) {
            // 不需要用 if 语句来限定
            results.add(new ArrayList<>(result));

            for (int i = beginIndex; i < nums.length; i++) {
                result.add(nums[i]);
                backtrack(nums, i + 1, result, results);
                result.removeLast();
            }
        }
    }
}
