package com.eric.util;

import com.eric.model.tree.TreeNode;

import java.util.*;

public class TreeCodec {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        List<String> result = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque();

        /**
         * 这个和常规的层序遍历稍微有点区别，在遍历到这层时，直接打印下一层
         */
        queue.add(root);
        result.add(String.valueOf(root.val));

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode father = queue.poll();

                if (father.left == null) {
                    result.add("null");
                } else {
                    queue.add(father.left);
                    result.add(String.valueOf(father.left.val));
                }

                if (father.right == null) {
                    result.add("null");
                } else {
                    queue.add(father.right);
                    result.add(String.valueOf(father.right.val));
                }
            }
        }

        return '[' + String.join(",", result) + ']';
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data.length() == 2) return null;

        Queue<String> input = new ArrayDeque<>(Arrays.asList(data.substring(1, data.length() - 1).split(",")));
        Queue<TreeNode> queue = new ArrayDeque<>();

        String treeVal = input.poll();
        TreeNode root = new TreeNode(Integer.valueOf(treeVal));
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            String leftVal = input.poll();
            if (leftVal == null || "null".equals(leftVal)) {
                node.left = null;
            } else {
                TreeNode left = new TreeNode(Integer.valueOf(leftVal));
                queue.add(left);
                node.left = left;
            }

            String rightVal = input.poll();
            if (rightVal == null || "null".equals(rightVal)) {
                node.right = null;
            } else {
                TreeNode right = new TreeNode(Integer.valueOf(rightVal));
                queue.add(right);
                node.right = right;
            }
        }
        return root;
    }
}