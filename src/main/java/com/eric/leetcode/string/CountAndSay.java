package com.eric.leetcode.string;

/**
 * 38. 报数
 *
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "1211"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-and-say
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountAndSay {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.countAndSaySpecificString("11122");
        System.out.println(solution.countAndSay(4));
    }

    /**
     * 递归
     */
    static class Solution {
        public String countAndSay(int n) {
            if (n == 1) return "1";
            return countAndSaySpecificString(countAndSay(n - 1));
        }

        /**
         * 主要流程是，获取 字符和字符出现的次数
         * @param s
         * @return
         */
        private String countAndSaySpecificString(String s) {
            String r = "";
            int i = 0;
            char prev = s.charAt(0);
            int count = 0;
            while (true) {
                while (i < s.length() && s.charAt(i) == prev) {
                    count++;
                    i ++;
                }

                r += "" + count + prev;
                if (i == s.length()) break;


                prev = s.charAt(i);
                count = 1;
                i ++;
            }
            return r;
        }
    }
}
