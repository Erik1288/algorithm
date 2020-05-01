package com.eric.leetcode.tree;


import com.eric.model.tree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 590. N叉树的后序遍历
 *
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NAryTreePostorderTraversal {
    class Solution {
        public List<Integer> postorder(Node root) {
            List<Integer> result = new ArrayList<>();
            postOrder(root, result);
            return result;
        }

        private void postOrder(Node root, List<Integer> result) {
            if (root == null) return ;

            for (Node child : root.children) {
                postOrder(child, result);
            }

            // ############
            result.add(root.val);
            // ############
        }
    }
}
