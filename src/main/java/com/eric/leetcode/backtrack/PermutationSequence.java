package com.eric.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Eric
 * Date: 2020/2/1
 */
public class PermutationSequence {
    public static void main(String[] args) {
        String permutation = new Solution().getPermutation(4, 17);
        System.out.println(permutation);
    }

    static class Solution {
        private int resultNo;
        private String finalResult = "";

        public String getPermutation(int n, int k) {
            boolean[] used = new boolean[n + 1];
            List<Integer> result = new ArrayList<>();
            backtrack(n, k, used, new StringBuilder());
            return finalResult;
        }

        /**
         * 我这种写法效率有点低。。。
         * @param n
         * @param k
         * @param used
         * @param result
         */
        private void backtrack(int n, int k, boolean[] used, StringBuilder result) {
            if (result.length() == n) {
                resultNo++;
                if (resultNo == k) finalResult = result.toString();
                return ;
            }

            for (int i = 1; i <= n; i++) {
                if (used[i] || !finalResult.isEmpty()) continue;

                used[i] = true;
                result.append(i);

                backtrack(n, k, used, result);

                used[i] = false;
                result.deleteCharAt(result.length() - 1);
            }
        }
    }
}
