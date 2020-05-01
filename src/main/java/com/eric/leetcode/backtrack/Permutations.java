package com.eric.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permutations {
    public static void main(String[] args) {
        List<List<Integer>> permute = new Solution().permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }

    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> results = new ArrayList<>();
            boolean[] used = new boolean[nums.length];
            backtrack(nums, used, new LinkedList<>(), results);
            return results;
        }

        private void backtrack(int[] nums, boolean[] used, LinkedList<Integer> result, List<List<Integer>> results) {
            if (result.size() == nums.length) {
                results.add(new ArrayList<>(result));
                return ;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue;

                used[i] = true;
                result.add(nums[i]);

                backtrack(nums, used, result, results);

                used[i] =false;
                result.removeLast();
            }
        }
    }

}
