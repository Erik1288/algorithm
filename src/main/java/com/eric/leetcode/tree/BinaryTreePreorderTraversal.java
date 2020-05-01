package com.eric.leetcode.tree;

import com.eric.model.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        preorderTraversal1(root, list);
        return list;
    }

    public static void preorderTraversal1(TreeNode root, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);

        while (stack.size() != 0) {
            TreeNode r = stack.pop();
            list.add(r.val);
            if (r.right != null) stack.push(r.right);
            if (r.left != null) stack.push(r.left);
        }
    }

    /**
     * 根右左
     * @param root
     * @param list
     */
    public static void antiPreorderTraversal(TreeNode root, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (stack.size() != 0) {
            TreeNode r = stack.pop();
            System.out.println(r.val);
            if (r.left != null) stack.push(r.left);
            if (r.right != null) stack.push(r.right);
        }
    }

}
