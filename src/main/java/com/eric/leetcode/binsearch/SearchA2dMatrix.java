package com.eric.leetcode.binsearch;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchA2dMatrix {
    public static void main(String[] args) {
        /**
         *                   ┌─────┬─────┬─────┬─────┐
         *                   │  1  │  3  │  5  │  7  │
         * ┌─────┐     ┌────▶│     │     │     │     │
         * │m[0] │     │     └─────┴─────┴─────┴─────┘
         * │     │─────┘
         * ├─────┤           ┌─────┬─────┬─────┬─────┐
         * │m[1] │           │ 10  │ 11  │ 16  │ 20  │
         * │     │──────────▶│     │     │     │     │
         * ├─────┤           └─────┴─────┴─────┴─────┘
         * │m[2] │
         * │     │─────┐     ┌─────┬─────┬─────┬─────┐
         * └─────┘     │     │ 23  │ 30  │ 34  │ 50  │
         *             └────▶│     │     │     │     │
         *                   └─────┴─────┴─────┴─────┘
         */
        int[][] m = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(searchMatrix(m, 10));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        int l = 0;
        int r = matrix.length * matrix[0].length - 1;
        int rl = matrix[0].length;

        while (l <= r) {
            int m = (l + r) / 2;
            if (target < matrix[m / rl][m % rl]) r = m - 1;
            else if (target > matrix[m / rl][m % rl]) l = m + 1;
            else return true;
        }

        return false;
    }
}
