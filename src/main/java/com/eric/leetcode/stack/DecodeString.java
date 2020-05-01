package com.eric.leetcode.stack;

import java.util.Stack;

/**
 * User: Eric
 * Date: 2020/2/8
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DecodeString {
    public static void main(String[] args) {
        new Solution().decodeString("3[a2[c]]");
    }

    /**
     * Refer:
     * https://leetcode-cn.com/problems/decode-string/solution/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/
     *
     * 不管怎么样，一定要在白纸上演示一遍，理解了含义，离成功只有大致的编码
     */
    static class Solution {
        class Tuple {
            int multiply;
            String lastResult;

            public Tuple(int multiply, String lastResult) {
                this.multiply = multiply;
                this.lastResult = lastResult;
            }
        }

        public String decodeString(String s) {
            Stack<Tuple> stack = new Stack<>();

            int multiply = 0;
            String lastRes = "";
            for (int i = 0; i < s.length(); i++) {
                if (isNumber(s.charAt(i))) {
                    multiply = multiply * 10 + (s.charAt(i) - '0');
                } else if (isLetter(s.charAt(i))) {
                    lastRes = lastRes + s.charAt(i);
                } else if ('[' == s.charAt(i)) {
                    stack.push(new Tuple(multiply, lastRes));
                    multiply = 0;
                    lastRes = "";
                } else if (']' == s.charAt(i)) {
                    Tuple tuple = stack.pop();
                    // 这里的逻辑非常容易乱，一定要抽象个方法来处理
                    lastRes = copy(lastRes, tuple.multiply);
                    lastRes = tuple.lastResult + lastRes;
                }
            }

            return lastRes;
        }

        private boolean isLetter(char c) {
            return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
        }

        private boolean isNumber(char c) {
            return Character.isDigit(c);
        }

        private String copy(String str, int multiply) {
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < multiply; i++) {
                tmp.append(str);
            }
            return tmp.toString();
        }
    }
}
