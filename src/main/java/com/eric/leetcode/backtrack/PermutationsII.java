package com.eric.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * User: Eric
 * Date: 2020/1/31
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PermutationsII {
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().permuteUnique(new int[]{1, 1, 3});
        System.out.println(lists);
    }

    static class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> results = new ArrayList<>();
            Arrays.sort(nums);
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

                // 去重，如果选了第2个1作为排列的第一个元素，这是第一个元素还没有用到，但如果第一个元素和第二个元素是一样的，一定会重复，所以在
                // 这种情况下，放弃这种选择
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                result.add(nums[i]);
                used[i] = true;

                backtrack(nums, used, result, results);

                used[i] = false;
                result.removeLast();
            }
        }
    }
}
