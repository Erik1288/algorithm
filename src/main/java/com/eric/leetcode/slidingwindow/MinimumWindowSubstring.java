package com.eric.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 76. 最小覆盖子串
 *
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
//        String s = new Solution().minWindow("a", "aa");
        String s = new Solution().minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }

    /**
     * Refer
     * https://leetcode-cn.com/problems/minimum-window-substring/solution/76-zui-xiao-fu-gai-zi-chuan-cshuang-zhi-zhen-mo-ba/
     */
    static class Solution {
        public String minWindow(String s, String t) {
            Map<Character, Integer> countInT = new HashMap<>();

            for (int i = 0; i < t.length(); i++) {
                countInT.put(t.charAt(i), countInT.getOrDefault(t.charAt(i), 0) + 1);
            }

            int left = 0;

            int minWindow = s.length();
            String window = "";

            int matchCount = 0;
            for (int right = 0; right < s.length(); right++) {
                // 技巧 用于消减无效的字符出现（也就是说，t中有2个'A'，s中如果有3个'A'，那么第三个'A'是无效的）
                char key = s.charAt(right);
                countInT.put(key, countInT.getOrDefault(key, 0) - 1);
                if (countInT.getOrDefault(s.charAt(right), 0) >= 0) matchCount ++;

                // 如果sliding window有效，那么开始考虑left右移
                while (matchCount == t.length()) {
                    // 趁着有效，赶紧统计一把
                    if (right - left + 1 <= minWindow) {
                        minWindow = right - left + 1;
                        window = s.substring(left, right + 1);
                    }

                    // 同上
                    key = s.charAt(left);
                    countInT.put(key, countInT.getOrDefault(key, 0) + 1);
                    if (countInT.getOrDefault(key, 0) > 0) matchCount --;

                    left ++;
                }
            }

            return window;
        }

    }
}
