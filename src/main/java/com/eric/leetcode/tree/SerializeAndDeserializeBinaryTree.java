package com.eric.leetcode.tree;

import com.eric.model.tree.TreeNode;

import java.util.*;

/**
 * User: Eric
 * Date: 2020/1/30
 *
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 示例: 
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = codec.deserialize("[]");
        String serialize = codec.serialize(root);
        System.out.println(serialize);
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
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
        public TreeNode deserialize(String data) {
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

}
