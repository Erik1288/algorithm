package com.eric.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
    /**
     * 回溯剪枝法
     *
     * 回溯的本质是枚举，但是很多分支其实是可以整体被剪枝，可以省去非常多的遍历时间
     *
     *                                                       ┌─┐
     *                                                       └─┘
     *                                                        │
     *                                            ┌───────────┴──────────────────────────────────────┐
     *                                            │                                                  X
     *                                            ▼                                                  ▼
     *                                           ┌─┐                                                ┌─┐
     *                                           │(│                                                │)│
     *                                           └─┘                                                └─┘
     *                                            │                                                  │
     *              ┌─────────────────────────────┴───────────────────┐                      ┌───────┴────────┐
     *              ▼                                                 ▼                      ▼                ▼
     *            ┌──┐                                              ┌──┐                   ┌──┐             ┌──┐
     *            │((│                                              │()│                   │)(│             │))│
     *            └──┘                                              └──┘                   └──┘             └──┘
     *              │                                                 │                      │                │
     *   ┌──────────┴───────────────────────┐                    ┌────┴────┐             ┌───┴──┐        ┌────┴───┐
     *   │                                  │                    │         X             │      │        │        │
     *   ▼                                  ▼                    ▼         ▼             ▼      ▼        ▼        ▼
     * ┌───┐                              ┌───┐                ┌───┐     ┌───┐         ┌───┐  ┌───┐    ┌───┐    ┌───┐
     * │(((│                              │(()│                │()(│     │())│         │)((│  │)()│    │))(│    │)))│
     * └───┘                              └───┘                └───┘     └───┘         └───┘  └───┘    └───┘    └───┘
     *   │                                  │
     *   └─────┐             ┌──────────────┴────────────┐
     *         ▼             ▼                           ▼
     *      ┌────┐        ┌────┐                      ┌────┐
     *      │((()│        │(()(│                      │(())│
     *      └────┘        └────┘                      └────┘
     *         │             │                           │
     *         └────┐        └────┐                 ┌────┘
     *              │             │                 │
     *              ▼             ▼                 ▼
     *           ┌─────┐       ┌─────┐           ┌─────┐
     *           │((())│       │(()()│           │(())(│
     *           └─────┘       └─────┘           └─────┘
     *              │             │                 │
     *              └───┐         └────┐        ┌───┘
     *                  │              │        │
     *                  ▼              ▼        ▼
     *              ┌──────┐       ┌──────┐ ┌──────┐
     *              │((()))│       │(()())│ │(())()│
     *              └──────┘       └──────┘ └──────┘
     *
     */
    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> results = new ArrayList<>();
            dfs(0, 0, n, "", results);
            return results;
        }

        /**
         * 类似于二叉树的DFS
         */
        private void dfs(int left, int right, int n, String result, List<String> results) {
            if (left == n && right == n) results.add(result);

            // 优先放 (
            if (left < n) { // left < n 减去 left超过一半 的分支
                dfs(left + 1, right, n, result + '(', results);
                // 思考下，这里为什么不需要进行类似于 result -= '(' 的操作
                // 为什么在 RestoreIpAddresses 这题中又需要。
                // 从函数传递的是mutable变量，还传递的是immutable变量来思考问题
            }
            if (right < left) { // right < left 来限制 ) 的数量
                dfs(left, right + 1, n, result + ')', results);
            }
        }
    }
}
