package com.eric.leetcode.trick;

import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        System.out.println(new Solution().largestNumber(new int[]{3, 30, 34, 5, 9}));
    }

    static class Solution {
        public String largestNumber(int[] nums) {
            if (nums.length == 1) return String.valueOf(nums[0]);

            String[] sortedNumbers = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                sortedNumbers[i] = String.valueOf(nums[i]);
            }

            Arrays.sort(sortedNumbers, (o1, o2) -> {
                String choose1 = o1 + o2;
                String choose2 = o2 + o1;
                return choose2.compareTo(choose1);
            });

            String join = String.join("", sortedNumbers);
            if (join.startsWith("0")) join = "0";

            return join;
        }
    }
}
