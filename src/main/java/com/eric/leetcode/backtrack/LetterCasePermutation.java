package com.eric.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Eric
 * Date: 2020/2/1
 *
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 *
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 *
 * 输入: S = "12345"
 * 输出: ["12345"]
 * 注意：
 *
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-case-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCasePermutation {
    public static void main(String[] args) {
        List<String> strings = new Solution().letterCasePermutation("12a4b");
        System.out.println(strings);
    }

    static class Solution {
        public List<String> letterCasePermutation(String S) {
            List<String> results = new ArrayList<>();
            backtrack(S, 0, "", results);
            return results;
        }

        private void backtrack(String s, int beginIndex, String result, List<String> results) {
            if (beginIndex == s.length()) {
                results.add(result);
                return ;
            }
            backtrack(s, beginIndex + 1, result + s.charAt(beginIndex), results);

            // 另外一路还是从beginIndex位置开始
            if (isLowercaseLetter(s.charAt(beginIndex))) {
                backtrack(s, beginIndex + 1, result + Character.toUpperCase(s.charAt(beginIndex)), results);
            } else if (isUppercaseLetter(s.charAt(beginIndex))) {
                backtrack(s, beginIndex + 1, result + Character.toLowerCase(s.charAt(beginIndex)), results);
            }
        }

        private boolean isUppercaseLetter(char c) {
            return c >= 'A' && c <= 'Z';
        }

        private boolean isLowercaseLetter(char c) {
            return c >= 'a' && c <= 'z';
        }
    }
}
