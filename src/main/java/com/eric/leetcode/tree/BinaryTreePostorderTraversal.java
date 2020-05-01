package com.eric.leetcode.tree;

import com.eric.model.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    public static void traversal(TreeNode root, List<Integer> list) {
        if (root == null) return ;

        traversal(root.left, list);
        traversal(root.right, list);
        list.add(root.val);
    }

    public static void traversal1(TreeNode root, LinkedList<Integer> list) {
        if (root == null) return ;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode r = stack.pop();
            list.addFirst(r.val);
            if (r.left != null) stack.push(r.left);
            if (r.right != null) stack.push(r.right);
        }
    }
}
