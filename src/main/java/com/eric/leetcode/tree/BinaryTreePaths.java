package com.eric.leetcode.tree;

import com.eric.util.TreeCodec;
import com.eric.model.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Eric
 * Date: 2020/2/2
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreePaths {
    public static void main(String[] args) {
        List<String> strings = new Solution().binaryTreePaths(TreeCodec.deserialize("[1,2,3,null,5]"));
        System.out.println(strings);
    }

    static class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> results = new ArrayList<>();
            preorder(root, "", results);
            return results;
        }

        /**
         *
         * @param root
         * @param path 这个path千万别设计成List<Integer>这种有状态的，下面这篇文章基本能表达心中的意思
         *             https://leetcode-cn.com/problems/binary-tree-paths/solution/fu-zhi-chuan-zhi-yu-yin-yong-chuan-zhi-by-vailing/
         * @param results
         */
        private void preorder(TreeNode root, String path, List<String> results) {
            if (root == null) return ;

            /**/
            path = path.isEmpty() ? "" + root.val : path + "->" + root.val;
            if (root.left == null && root.right == null) {
                results.add(path);
            }
            /**/

            preorder(root.left, path, results);
            preorder(root.right, path, results);
        }
    }
}
