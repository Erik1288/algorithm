package com.eric.leetcode.dfs;

/**
 * 200. 岛屿数量
 *
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(new Solution().numIslands(grid));
    }

    /**
     * Refer
     * https://leetcode-cn.com/problems/number-of-islands/solution/dfs-bfs-bing-cha-ji-python-dai-ma-java-dai-ma-by-l/
     */
    static class Solution {
        private boolean[][] visited;
        private int row = 0;
        private int col = 0;

        public int numIslands(char[][] grid) {
            this.row = grid.length;
            if (this.row == 0) return 0;
            this.col = grid[0].length;
            if (this.col == 0) return 0;

            visited = new boolean[this.row][this.col];
            int numIslands = 0;

            for (int i = 0; i < this.row; i++) {
                for (int j = 0; j < this.col; j++) {
                    // 如果当前的节点未访问过的岛屿，那就开始dfs扩散
                    if (grid[i][j] == '1' && !visited[i][j]) {
                        dfs(grid, i, j);
                        numIslands ++;
                    }
                }
            }

            return numIslands;
        }

        private void dfs(char[][] grid, int x, int y) {
            if (grid[x][y] != '1') {
                return ;
            } else {
                visited[x][y] = true;
//                // test
//                System.out.println("x:" + x + " y:" + y);
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


    }
}
