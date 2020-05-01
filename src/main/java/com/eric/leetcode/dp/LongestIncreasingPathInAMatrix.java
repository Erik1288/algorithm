package com.eric.leetcode.dp;

import java.util.PriorityQueue;

/**
 * 329. 矩阵中的最长递增路径
 *
 * 给定一个整数矩阵，找出最长递增路径的长度。
 *
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 *
 * 示例 1:
 *
 * 输入: nums =
 * [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 * 示例 2:
 *
 * 输入: nums =
 * [
 *   [3,4,5],
 *   [3,2,6],
 *   [2,2,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
//        int[][] matrix = new int[3][3];
//        matrix[0] = new int[]{9, 9, 4};
//        matrix[1] = new int[]{6, 6, 8};
//        matrix[2] = new int[]{2, 1, 1};
//        int i = new Solution().longestIncreasingPath(matrix);
        int[][] matrix = new int[1][];
        matrix[0] = new int[]{1, 2};
        int i = new Solution().longestIncreasingPath(matrix);
        System.out.println(i);
    }

    static class Solution {
        public int longestIncreasingPath(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return 0;

            /**
             * 第一步写出dp方程
             * dp[m][n] = 1 + max(dp[][], dp[][], dp[][], dp[][] as dp[i][j] where matrix[i][j] < matrix[m][n])
             * 随便找一个点试着去求解下：
             * [
             *   [9,9,4],
             *   [6,6,8],
             *   [2,1,1]
             * ]
             * dp[0][0] = 1 + max(dp[1][0])
             * dp[1][0] = 1 + max(dp[1][0])
             * dp[2][0] = 1 + max(dp[2][2])
             * dp[2][2] = 1
             * 顺着这个依赖找，发现解dp方程的关键是找到matrix的最小值，求解出dp值后，然后依次变大，这样才能顺着依赖链求解
             */

            int m = matrix.length;
            int n = matrix[0].length;

            int longestPath = 0;

            // 需要从小到大的遍历顺序
            PriorityQueue<Cell> minHeap = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    minHeap.add(new Cell(matrix[i][j], i, j));
                }
            }

            int[][] dp = new int[m + 1][n + 1];

            while (!minHeap.isEmpty()) {
                Cell cell = minHeap.poll();
                int row = cell.x;
                int col = cell.y;
                int max = 0;
                // 查看比自己更小的邻居
                // top
                if (row - 1 >= 0 && matrix[row - 1][col] < matrix[row][col]) {
                    max = max(max, dp[row - 1][col]);
                }
                // bottom
                if (row + 1 < m && matrix[row + 1][col] < matrix[row][col]) {
                    max = max(max, dp[row + 1][col]);
                }
                // left
                if (col - 1 >= 0 && matrix[row][col - 1] < matrix[row][col]) {
                    max = max(max, dp[row][col - 1]);
                }
                // right
                if (col + 1 < n && matrix[row][col + 1] < matrix[row][col]) {
                    max = max(max, dp[row][col + 1]);
                }

                dp[row][col] = max + 1;
                longestPath = max(longestPath, dp[row][col]);
            }

            return longestPath;
        }

        private int max(int a, int b) {
            return a > b ? a : b;
        }

        class Cell {
            public int value;
            public int x;
            public int y;

            public Cell(int value, int x, int y) {
                this.value = value;
                this.x = x;
                this.y = y;
            }
        }
    }
}
