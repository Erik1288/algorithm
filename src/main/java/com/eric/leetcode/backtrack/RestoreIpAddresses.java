package com.eric.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原IP地址
 *
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RestoreIpAddresses {
    public static void main(String[] args) {
        List<String> strings = new Solution().restoreIpAddresses("25525511135");
        List<String> strings1 = new Solution().restoreIpAddresses("");
        List<String> strings2 = new Solution().restoreIpAddresses("0000");
        System.out.println(strings2);
    }

    static class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> results = new ArrayList<String>();

            if (s == null) return null;
            if (s.length() <= 3) return results;
            if (s.length() > 12) return results;

            process(s, 0, new ArrayList<>(), results);
            return results;
        }

        private void process(String s, int pos, List<String> segments, List<String> results) {
            // 是不是有4短，并且整个s被完整切割了
            if (segments.size() == 4 && pos == s.length()) {
                results.add(String.join(".", segments));
            }

            // 每个segment最多尝试1-3位
            for (int i = 1; i <= 3 && pos + i <= s.length(); i++) {
                String segment = s.substring(pos, pos + i);
                if (valid(segment)) {
                    segments.add(segment);
                    process(s, pos + i, segments, results);
                    segments.remove(segments.size() - 1);
                }
            }
        }

        private boolean valid(String seg) {
            if (seg.length() != 1 && seg.startsWith("0")) {
                return false;
            }
            try {
                Integer integer = Integer.valueOf(seg);
                if (integer >= 0 && integer <= 255) return true;
                else return false;
            } catch (Exception e) {
                return false;
            }
        }
    }
}
