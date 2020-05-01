package com.eric.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        // 如果是奇数个，肯定不是有效的
        if (s.length() % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mappings = new HashMap<>();
        mappings.put('}', '{');
        mappings.put(']', '[');
        mappings.put(')', '(');

        // 防止peek空stack报错
        stack.push('?');

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '}' || s.charAt(i) == ']' || s.charAt(i) == ')') {
                if (stack.peek() == mappings.get(s.charAt(i))) {
                    stack.pop();
                } else{
                    stack.push(s.charAt(i));
                }
            }  else {
                stack.push(s.charAt(i));
            }
        }

        return stack.size() == 1;
    }

}
