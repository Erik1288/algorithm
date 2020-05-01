package com.eric.leetcode.string;

/**
 * User: Eric
 * Date: 2020/2/4
 *
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 *
 * 进阶：
 *
 * 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseWordsInAString {
    /**
     * 空间复杂度O(1) 的要求是开辟的新空间大小与输入的内容无关，这题输入的是字符串，
     * 输出的也是字符串，也就是说必须在原字符串上进行修改，但是 Java String 用
     * final 修饰了，修改一次实际上重新开辟了等同大小新的空间，如果把输入和输出都换
     * 成 char[] 才可以实现O(1)。
     */
    class Solution {
        public String reverseWords(String s) {
            return null;
        }

        private void swap(String s, int begin, int end) {
        }
    }
}
