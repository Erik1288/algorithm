package com.eric.leetcode.trie;

import java.util.Stack;

/**
 * User: Eric
 * Date: 2020/1/27
 *
 * 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
 *
 * 注意：1 ≤ k ≤ n ≤ 109。
 *
 * 示例 :
 *
 * 输入:
 * n: 13   k: 2
 *
 * 输出:
 * 10
 *
 * 解释:
 * 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KthSmallestInLexicographicalOrder {
    public static void main(String[] args) {
        int kthNumber = new Solution().findKthNumber(130, 20);
        System.out.println(kthNumber);
    }

    static class Solution {
        /**
         * 这个题目就是Trie数的前序遍历
         * @param n
         * @param k
         * @return
         */
        public int findKthNumber(int n, int k) {
            // 特殊情况
            if (n <= 9) {
                return k;
            }

            Stack<Integer> stack = new Stack<>();
            // 特殊处理第一层，具体原因查看LexicographicalNumbers
            for (int i = 9; i >= 1; i--) {
                stack.push(i);
            }

            while (!stack.isEmpty()) {
                Integer node = stack.pop();
                if (--k == 0) {
                    return node;
                }

                // 从right到left加入stack
                int max;
                if (n - node * 10 >= 10) {
                    max = 9;
                } else {
                    max = n - node * 10;
                }

                for (int i = max; i >= 0; i--) {
                    stack.push(node * 10 + i);
                }
            }

            throw new RuntimeException("");
        }
    }
}
