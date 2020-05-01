package com.eric.leetcode.tree;

import com.eric.util.TreeCodec;
import com.eric.model.tree.TreeNode;

import java.util.*;

/**
 *
 * 314. 二叉树的垂直遍历
 *
 * 给定一个二叉树，返回其结点 垂直方向（从上到下，逐列）遍历的值。
 *
 * 如果两个结点在同一行和列，那么顺序则为 从左到右。
 *
 * 示例 1：
 *
 * 输入: [3,9,20,null,null,15,7]
 *
 *    3
 *   /\
 *  /  \
 * 9   20
 *     /\
 *    /  \
 *   15   7
 *
 * 输出:
 *
 * [
 *   [9],
 *   [3,15],
 *   [20],
 *   [7]
 * ]
 * 示例 2:
 *
 * 输入: [3,9,8,4,0,1,7]
 *
 *      3
 *     /\
 *    /  \
 *   9    8
 *   /\   /\
 *  /  \ /  \
 * 4   0 1   7
 *
 * 输出:
 *
 * [
 *   [4],
 *   [9],
 *   [3,0,1],
 *   [8],
 *   [7]
 * ]
 * 示例 3:
 *
 * 输入: [3,9,8,4,0,1,7,null,null,null,2,5]（注意：0 的右侧子节点为 2，1 的左侧子节点为 5）
 *
 *      3
 *     /\
 *    /  \
 *    9   8
 *   /\  /\
 *  /  \/  \
 *  4  01   7
 *     /\
 *    /  \
 *    5   2
 *
 * 输出:
 *
 * [
 *   [4],
 *   [9,5],
 *   [3,0,1],
 *   [8,2],
 *   [7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-vertical-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreeVerticalOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = TreeCodec.deserialize("[3,9,20,null,null,15,7]");
        List<List<Integer>> lists = new Solution().verticalOrder(root);
        System.out.println(lists);
    }

    static class Solution {
        class IndexedTreeNode {
            int index;
            TreeNode node;

            IndexedTreeNode(int index, TreeNode node) {
                this.index = index;
                this.node = node;
            }
        }

        public List<List<Integer>> verticalOrder(TreeNode root) {
            // 按照 ... -2,-1,0,1,2 ... 的顺序输出
            TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();

            Queue<IndexedTreeNode> queue = new ArrayDeque<>();
            if (root != null) queue.offer(new IndexedTreeNode(0, root));

            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    IndexedTreeNode indexedTreeNode = queue.poll();
                    int currentIndex = indexedTreeNode.index;
                    TreeNode currentNode = indexedTreeNode.node;

                    List<Integer> result = treeMap.getOrDefault(currentIndex, new ArrayList<>());
                    result.add(currentNode.val);
                    treeMap.put(currentIndex, result);

                    if (currentNode.left != null) {
                        queue.add(new IndexedTreeNode(currentIndex - 1, currentNode.left));
                    }

                    if (currentNode.right != null) {
                        queue.add(new IndexedTreeNode(currentIndex + 1, currentNode.right));
                    }
                }
            }

            return new ArrayList<>(treeMap.values());
        }
    }
}
