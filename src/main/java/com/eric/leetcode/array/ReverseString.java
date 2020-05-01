package com.eric.leetcode.array;

/**
 *
 * 344. 反转字符串
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 * 示例 1：
 *
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 *
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] c = {'2', '3', '4'};
//        char[] c = {'1', '2', '3', '4'};
        SolutionTwo.reverseString(c);
//        SolutionOne.reverseString(c);
        System.out.println(c);
    }

    /**
     * 双指针法
     */
    static class SolutionOne {
        public static void reverseString(char[] s) {
            int l = 0;
            int r = s.length - 1;

            while (l < r) {
                char t = s[l];
                s[l] = s[r];
                s[r] = t;

                l ++;
                r --;
            }
        }
    }

    /**
     * 递归法
     */
    static class SolutionTwo {
        public static void reverseString(char[] s) {
            reverseString(s, 0, s.length - 1);
        }

        private static void reverseString(char[] s, int l, int r) {
            if (l >= r) return ;
            swap(s, l, r);
            reverseString(s, l + 1, r - 1);
        }

        private static void swap(char[] s, int a, int b) {
            char t = s[a];
            s[a] = s[b];
            s[b] = t;
        }
    }
}
