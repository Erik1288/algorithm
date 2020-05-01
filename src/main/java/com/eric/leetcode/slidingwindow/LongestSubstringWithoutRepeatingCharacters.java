package com.eric.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestSubstringWithoutRepeatingCharacters {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int window = 0;
            // 每一个字符最后出现的位置
            Map<Character, Integer> dict = new HashMap<>();
            // left 和 right 分别为 滑动窗口的 [left, right]
            int left = 0;
            for (int right = 0; right < s.length(); right++) {
                if (dict.containsKey(s.charAt(right))) {
                    // 出现过，不一定在窗口内部
                    // 窗口的 left 只能往 大的方向移动，如果dict里的值在窗口的外部(left的左边，比小)，那么left的值不会变化
                    left = max(left, dict.get(s.charAt(right)) + 1);
                }
                // 更新最后出现的位置
                dict.put(s.charAt(right), right);
                // 窗口快照
                window = max(window, right - left + 1);
            }
            return window;
        }

        private int max(int a, int b) {
            return a > b ? a : b;
        }
    }
}
