package com.eric.leetcode.array.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergIntervals {
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals == null || intervals.length == 0) {
                return intervals;
            }

            List<int[]> results = new ArrayList<>();

            // 按照区间left的大小进行从小到大排序
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            int i = 0;
            while (i < intervals.length) {
                int left = intervals[i][0];
                int right = intervals[i][1];
                // 下一个区间的left<=当前区间right，说明是有overlap的
                while (i + 1 < intervals.length && intervals[i + 1][0] <= right) {
                    right = max(right, intervals[i + 1][1]);
                    i ++;
                }
                results.add(new int[]{left, right});
                i ++;
            }

            int[][] r = new int[results.size()][];
            for (int j = 0; j < r.length; j++) {
                r[j] = results.get(j);
            }
            return r;
        }

        private int max(int a, int b) {
            return a > b ? a : b;
        }
    }
}
