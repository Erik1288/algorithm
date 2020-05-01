package com.eric.leetcode.dp;

/**
 * User: Eric
 * Date: 2020/1/28
 *
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 *
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 *
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class EditDistance {
    class Solution {
        /**
         * Refer: https://leetcode-cn.com/problems/edit-distance/solution/tu-biao-geng-hao-li-jie-dp-by-kao-la-7/
         *
         * dp[i][j]为word1[0:i]编辑到word2[0:j]的最短距离
         *
         * if word1[i] == word[j]
         *      表示不需要任何编辑
         *      dp[i][j] = dp[i-1][j-1]
         * else
         *      需要编辑
         *      dp[i][j] = min(
         *          dp[i-1][j], // 删除
         *          dp[i][j-1], // 增加
         *          dp[i-1][j-1] // 修改
         *          ) + 1
         *
         * ┌───┬───┬───┬───┬───┐
         * │   │   │ r │ o │ s │
         * ├───┼───┼───┼───┼───┤
         * │   │ 0 │ 1 │ 2 │ 3 │
         * ├───┼───┼───┼───┼───┤
         * │ h │ 1 │   │   │   │
         * ├───┼───┼───┼───┼───┤
         * │ o │ 2 │   │   │   │
         * ├───┼───┼───┼───┼───┤
         * │ r │ 3 │   │   │   │
         * ├───┼───┼───┼───┼───┤
         * │ s │ 4 │   │   │   │
         * ├───┼───┼───┼───┼───┤
         * │ e │ 5 │   │   │   │
         * └───┴───┴───┴───┴───┘
         *
         * 看第一行
         * dp[0][1] 将 ''编辑成r 的最小距离，其实就是 增加一个r
         * dp[0][2] 将 ''编辑成ro 的最小距离，其实就是 增加一个ro
         * dp[0][3] 将 ''编辑成ros 的最小距离，其实就是 增加一个ros
         *
         * dp[2][2] 将 ho编辑成ro 的最小距离，其实就是将 h编辑成r 的最小距离
         *
         * 将上面的dp方程转化为图就最好理解:
         * if word1[i] == word[j]
         *      那么就找该格子的左上角的那个格子，那个格子是多少，就填写多少
         * else
         *      那么就找 min(左边的格子，上边的格子，左上角的格子) + 1
         *
         *
         * @param word1
         * @param word2
         * @return
         */
        public int minDistance(String word1, String word2) {
            return 0;
        }
    }
}
