package com.eric.leetcode.tree;

import com.eric.model.tree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N叉树的前序遍历
 *
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NAryTreePreorderTraversal {
    class Solution {
        public List<Integer> preorder(Node root) {
            List<Integer> result = new ArrayList<>();
            preOrder(root, result);
            return result;
        }

        private void preOrder(Node root, List<Integer> result) {
            if (root == null) return ;

            /*################*/
            result.add(root.val);
            /*################*/

            for (Node child : root.children) {
                preOrder(child, result);
            }
        }
    }
}
