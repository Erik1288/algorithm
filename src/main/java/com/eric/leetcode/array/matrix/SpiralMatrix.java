package com.eric.leetcode.array.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 54. 螺旋矩阵
 *
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] m = {{1,2,3}, {4,5,6}, {7,8,9}};

        List<Integer> integers = new Solution().spiralOrder(m);
        System.out.println(integers);
    }

    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();

            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return result;

            int top = 0;
            int left = 0;
            int bottom = matrix.length - 1;
            int right = matrix[0].length - 1;

            while (true) {
                // 向右移动
                for (int col = left; col <= right; col++) {
                    result.add(matrix[top][col]);
                }
                top ++;
                if (top > bottom) break;

                // 向下移动
                for (int row = top; row <= bottom; row++) {
                    result.add(matrix[row][right]);
                }
                right --;
                if (left > right) break;

                // 向左移动
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom --;
                if (top > bottom) break;

                // 向上移动
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left ++;
                if (left > right)  break;
            }

            return result;
        }
    }
}
