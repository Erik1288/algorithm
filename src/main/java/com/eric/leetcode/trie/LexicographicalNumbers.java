package com.eric.leetcode.trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * User: Eric
 * Date: 2020/1/27
 * <p>
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 * <p>
 * 例如，
 * <p>
 * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 * <p>
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lexicographical-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LexicographicalNumbers {
    public static void main(String[] args) {
        List<Integer> integers = new Solution().lexicalOrder(103);
        System.out.println(integers);
    }

    static class Solution {

        public List<Integer> lexicalOrder(int n) {
            List<Integer> result = new ArrayList<>();
            preorder(n, result);
            return result;
        }

        private void preorder(int n, List<Integer> result) {
            // 先考虑特殊情况
            if (n <= 9) {
                for (int i = 1; i <= n; i++) {
                    result.add(i);
                }
                return ;
            }

            // 接下去的部分可以参考下二叉树的前序遍历，区别就是对第一层的处理
            Stack<Integer> stack = new Stack<>();
            // 在二叉树的遍历中，stack只需要放一个root就好，应该可以顺着root找到left和right
            // 但是在trie中，这是一棵虚拟的10叉树，但是第一层只有9叉，原因是不能从0开始
            // 所以最好的办法就是对第一层进行特殊处理
            // 从right到left将子节点放入stack中
            for (int i = 9; i >=1 ; i--) {
                stack.push(i);
            }

            while (!stack.isEmpty()) {
                Integer node = stack.pop();
                result.add(node);

                // 当前的node已经遍历到了，接下去先把当前node的children从right到left放入stack
                int max;
                if (n - node * 10 >= 10) {
                    // 子节点全满
                    max = 9;
                } else {
                    // 子节点不全满
                    max = n - node * 10;
                }

                for (int i = max; i >= 0; i--) {
                    stack.push(node * 10 + i);
                }
            }
        }
    }
}
