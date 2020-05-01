package com.eric.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        List<String> strings = new Solution().letterCombinations("23");
        System.out.println(strings);
    }

    static class Solution {
        private String[] map = new String[] {
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };

        public List<String> letterCombinations(String digits) {
            List<String> results = new ArrayList<>();
            backtrack(digits, 0, new StringBuilder(), results);
            return results;
        }

        /**
         * 这个回溯有两个推进的方向，一个是第几个数字，这个用递归的digitIndex来推进，另一个是第几个字母，这个用方法内部的for来推进
         * @param digits
         * @param digitIndex
         * @param result
         * @param results
         */
        private void backtrack(String digits, int digitIndex, String result, List<String> results) {
            if (digitIndex == digits.length()) {
                if (result.length() != 0) results.add(result);
                return ;
            }

            String letters = map[digits.charAt(digitIndex) - '0'];
            for (int i = 0; i < letters.length(); i++) {
                // 做决定
                backtrack(digits, digitIndex + 1, result + letters.charAt(i), results);
                // 撤销决定，但这里不需要撤销，如果result是用StringBuilder的话，就需要撤销
            }
        }

        private void backtrack(String digits, int digitIndex, StringBuilder result, List<String> results) {
            if (digitIndex == digits.length()) {
                if (result.length() != 0) results.add(result.toString());
                return ;
            }

            String letters = map[digits.charAt(digitIndex) - '0'];
            for (int i = 0; i < letters.length(); i++) {
                // 做决定
                result.append(letters.charAt(i));
                backtrack(digits, digitIndex + 1, result, results);
                // 撤销决定
                result.deleteCharAt(result.length() - 1);
            }
        }
    }
}
