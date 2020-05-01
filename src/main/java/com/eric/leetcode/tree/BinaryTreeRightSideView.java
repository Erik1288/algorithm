package com.eric.leetcode.tree;

import com.eric.model.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 199. 二叉树的右视图
 *
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreeRightSideView {
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Deque<TreeNode> deque = new ArrayDeque<>();
            if (root != null) deque.add(root);

            while (!deque.isEmpty()) {
                result.add(deque.getLast().val);

                int sizeLevel = deque.size();
                for (int i = 0; i < sizeLevel; i++) {
                    TreeNode treeNode = deque.pollFirst();

                    if (treeNode.left != null) deque.add(treeNode.left);
                    if (treeNode.right != null) deque.add(treeNode.right);
                }
            }

            return result;
        }
    }
}
