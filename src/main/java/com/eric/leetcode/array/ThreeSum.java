package com.eric.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: Eric
 * Date: 2020/2/7
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum {
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().threeSum(new int[]{-2,0,0,2,2});
//        List<List<Integer>> lists = new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> results = new ArrayList<>();

            // 固定的这位不断往右移，每次只要统计fixed右边的数组就可以
            for (int fixed = 0; fixed < nums.length; fixed++) {
                // 剪枝优化
                if (nums[fixed] > 0) break; // 最小的数字都大于0，那么肯定无解了

                // 去重
                if (fixed > 0 && nums[fixed] == nums[fixed - 1]) continue;

                int left = fixed + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[fixed] + nums[left] + nums[right];
                    if (sum > 0) {
                        right --;
                    } else if (sum < 0) {
                        left ++;
                    } else {
                        List<Integer> result = new ArrayList();
                        result.add(nums[fixed]);
                        result.add(nums[left]);
                        result.add(nums[right]);
                        results.add(result);

                        // [-2,0,0,2,2]去重
                        //     l     r
                        do {
                            left++;
                        } while (left < right && nums[left - 1] == nums[left]);

                        do {
                            right--;
                        } while (left < right && nums[right + 1] == nums[right]);
                    }
                }
            }

            return results;
        }
    }
}
