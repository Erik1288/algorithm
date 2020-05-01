package com.eric.leetcode.dfs;

/**
 * 695. 岛屿的最大面积
 *
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 *
 * 示例 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 *
 * 示例 2:
 *
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 *
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxAreaOfIsland {
    class Solution {
        private boolean[][] visited;
        private int newVisitedArea;
        private int row = 0;
        private int col = 0;

        public int maxAreaOfIsland(int[][] grid) {
            this.row = grid.length;
            if (this.row == 0) return 0;
            this.col = grid[0].length;
            if (this.col == 0) return 0;

            visited = new boolean[this.row][this.col];
            int maxArea = 0;

            for (int i = 0; i < this.row; i++) {
                for (int j = 0; j < this.col; j++) {
                    // 如果当前的节点未访问过的岛屿，那就开始dfs扩散
                    if (grid[i][j] == 1 && !visited[i][j]) {
                        dfs(grid, i, j);
                        maxArea = max(maxArea, this.newVisitedArea);
                        this.newVisitedArea = 0;
                    }
                }
            }

            return maxArea;
        }

        private void dfs(int[][] grid, int x, int y) {
            if (grid[x][y] != 1) {
                return ;
            } else {
                if (!visited[x][y]) {
                    this.newVisitedArea ++;
                    visited[x][y] = true;
                }
            }

            /**
             * 右下左上顺序进行dfs
             *           (x-1, y)
             * (x, y-1)  (x,   y)  (x, y+1)
             *           (x+1, y)
             */
            if (valid(x, y + 1) && !visited[x][y + 1])
                dfs(grid, x, y + 1);
            if (valid(x + 1, y) && !visited[x + 1][y])
                dfs(grid, x + 1, y);
            if (valid(x, y - 1) && !visited[x][y - 1])
                dfs(grid, x, y - 1);
            if (valid(x - 1, y) && !visited[x - 1][y])
                dfs(grid, x - 1, y);
        }

        private boolean valid(int x, int y) {
            return (x >= 0 && x < row) && (y >= 0 && y < col);
        }

        private int max(int a, int b) {
            return a > b ? a : b;
        }
    }
}
