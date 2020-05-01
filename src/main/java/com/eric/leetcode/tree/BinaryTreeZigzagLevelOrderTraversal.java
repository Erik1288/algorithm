package com.eric.leetcode.tree;

import com.eric.model.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 103. 二叉树的锯齿形层次遍历
 *
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreeZigzagLevelOrderTraversal {


    /**
     * 双栈
     *
     *                            R                   L
     * ┌────┐      │           │                         │
     * │ s1 │   1  │           │  7 ◀─ 6 ◀─ 5 ◀─ 4 ◀─ 3  │
     * └────┘      │           │                         │
     *             │  L     R  │                         │  L                                  R
     * ┌────┐      │           │                         │
     * │ s2 │      │  2 ◀── 3  │                         │  8 ◀─ 9 ◀─10 ◀─11 ◀─12 ◀─13 ◀─14 ◀─15
     * └────┘      │           │                         │
     *
     *
     * 从上图可以看出，不管是s1还是s2，都是从 last -> first 的遍历方式，符合 stack 天生的特性
     * 当level=2时，为了构建level=3的数据，需要从right开始；
     * 当level=3时，为了构建level=4的数据，需要从left开始。
     */
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> results = new ArrayList<>();
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();

            if (root != null) {
                s1.push(root);
            }

            int level = 1;
            while (!s1.isEmpty() || !s2.isEmpty()) { // end while s1 is empty and s2 is empty
                Stack<TreeNode> needToDrain = s1.empty() ? s2 : s1;
                Stack<TreeNode> needToFill = s1.empty() ? s1 : s2;
                int sizeLevel = needToDrain.size();

                List<Integer> result = new ArrayList<>();

                for (int i = 0; i < sizeLevel; i++) {
                    TreeNode node = needToDrain.pop();
                    result.add(node.val);

                    if (level % 2 == 1) {
                        // 奇数层
                        if (node.left != null) needToFill.push(node.left);
                        if (node.right != null) needToFill.push(node.right);
                    } else {
                        // 偶数层
                        if (node.right != null) needToFill.push(node.right);
                        if (node.left != null) needToFill.push(node.left);

                    }
                }
                level ++;

                results.add(result);
            }

            return results;
        }
    }
}
