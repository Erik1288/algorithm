package com.eric.leetcode.trick;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
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
        int[] a = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(a);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        Arrays.sort(nums); // quick sort o(nlgn)

        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;

            if (nums[i] > 0) break;

            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    List<Integer> result = new ArrayList<>(3);
                    result.add(nums[i]);
                    result.add(nums[l]);
                    result.add(nums[r]);
                    rs.add(result);

                    l++;r--;
                }
                while (nums[i] + nums[l] + nums[r] > 0 && l < r) r--;
                while (nums[i] + nums[l] + nums[r] < 0 && l < r) l++;
            }
        }

        return rs;
    }
}
