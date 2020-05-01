package com.eric.leetcode.backtrack;

import java.util.HashMap;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 *
 * 输入: 4 输出: [ [".Q..", // 解法 1 "...Q", "Q...", "..Q."],
 *
 * ["..Q.", // 解法 2 "Q...", "...Q", ".Q.."] ] 解释: 4 皇后问题存在两个不同的解法。
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NQueens {
    public static void main(String[] args) {
        int a = maxSubArrayLen(new int[] {-2,-1,2,1}, 1);
        System.out.println(a);
    }

    /*
     * 建立前缀和:如果当前前缀和正好等于k，那么从开头到此位置的子数组就是一个符合要求的解，但不一定是最长的子数组，使用哈希表来建立前缀和和其索引之间的映射
     * 算法原理：sum(0,i) = sum(0, j-1) + sum(j,i) nums[1,-1,5,-2,3], k = 3
     * sum[1,0,5,3,6] 我们可以看到前缀和的第四个数字为3，和k相同，则说明前四个数字就是符合题意的一个子数组 nums[-2,-1,2,1], k
     * = 1 sum[-2,-3,-1,0] 我们发现前缀和中没有数字等于k，但是我们知道这个例子的答案是[-1, 2]，
     * 那么我们看前缀和数组的第一和第三个数字，我们是否能看出一些规律呢，没错，第三个数字-1减去k得到第一个数字-2，这就是规律，这也是前缀和求区间和的方法，
     * 但是由于累计和数组中可能会有重复数字，而哈希表的关键字不能相同，比如下面这个例子： nums: [1, 0, -1], k = -1 sums: [1,
     * 1, 0] sums: [1,0] 我们只要保存第一个出现该前缀和的位置，后面再出现直接跳过（最长的子数组肯定是左边界肯定是最早出现的）
     */
    public static int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            // 建立累计和
            sum += nums[i];
            if (sum == k) {
                // 如果累计和正好等于k,那么res等于此时的长度即（i+1),注意此时的res不一定是最大值
                res = i + 1;
            } else if (map.containsKey(sum - k)) {
                // 此时出现sum(0,i) = sum(0, j-1) + sum(j,i),其中sum(j,i) = k
                // sum(0,i)的长度为i+1，sum(0,j-1)的长度是j(由于我们的map保存的是index所以长度需要加1)
                // 举个例子
                // [-2, -1, 2, 1]， k=1
                // sum[-2,-3,-1,0]
                // i=2的时候-1-（1） =-2, map.get(sum-k) = 0,对应的index0，它的长度为 1.
                // 所以sum(j,i)为k的时候，sum(j,i)的长度为i+1-（map.get(sum-k)+1)即i-map.get(sum-k)
                res = Math.max(res, i + 1 - (map.get(sum - k) + 1));
            }
            // 如果map中不包括sum,把sum放入map中
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return res;
    }

}
