package com.eric.leetcode.tree;


import com.eric.util.TreeCodec;
import com.eric.model.tree.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = TreeCodec.deserialize("[3,9,20,null,null,15,7]");
        List<List<Integer>> lists = new SolutionPostOrder().levelOrder(root);
//        List<List<Integer>> lists = new SolutionPreOrder().levelOrder(root);
        System.out.println(lists);
    }

    static class SolutionPreOrder {
        public List<List<Integer>> levelOrder(TreeNode root) {
            TreeMap<Integer, List<Integer>> level2List = new TreeMap<>();
            preOrder(root, 0, level2List);

            return new ArrayList<>(level2List.values());
        }

        private void preOrder(TreeNode root, int level, TreeMap<Integer, List<Integer>> level2Results) {
            if (root == null) return ;

            /*################################*/
            List<Integer> list = level2Results.get(level);
            if (list == null) {
                list = new ArrayList<>();
                level2Results.put(level, list);
            }
            list.add(root.val);
            /*################################*/

            preOrder(root.left, level + 1, level2Results);
            preOrder(root.right, level + 1, level2Results);
        }
    }

    static class SolutionPostOrder {
        public List<List<Integer>> levelOrder(TreeNode root) {
            TreeMap<Integer, List<Integer>> level2List = new TreeMap<>();
            preOrder(root, 0, level2List);

            return new ArrayList<>(level2List.values());
        }

        private void preOrder(TreeNode root, int level, TreeMap<Integer, List<Integer>> level2Results) {
            if (root == null) return ;

            preOrder(root.left, level + 1, level2Results);
            preOrder(root.right, level + 1, level2Results);

            /*################################*/
            List<Integer> list = level2Results.get(level);
            if (list == null) {
                list = new ArrayList<>();
                level2Results.put(level, list);
            }
            list.add(root.val);
            /*################################*/
        }
    }

    /**
     * 最最通常的方式，夸张点说，闭着眼睛都要能写出来
     */
    static class SolutionIteration {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            levelOrderImpl(root, result);
            return result;
        }

        public void levelOrderImpl(TreeNode root, List<List<Integer>> result) {
            if (root == null) return ;
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int lvlSize = queue.size();

                List<Integer> lvlRst = new ArrayList<>(lvlSize);
                for (int i = 0; i < lvlSize; i++) {
                    TreeNode node = queue.poll();
                    lvlRst.add(node.val);
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                result.add(lvlRst);
            }
        }
    }


}
