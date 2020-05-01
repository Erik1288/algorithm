package com.eric.leetcode.tree;

import com.eric.model.tree.TreeNode;
import com.eric.util.TreeCodec;

import java.util.Arrays;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        TreeNode tree = new Solution().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(TreeCodec.serialize(tree));
    }

    /**
     * 用完全二叉树来做例子，容易理解出preorder的取值范围
     */
    static class Solution {
        /**
         * refer: https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/python-di-gui-xiang-jie-by-jalan/
         * 有slice的语言真的优秀啊，秀啊，啊。。。
         *
         * @param preorder
         * @param inorder
         * @return
         */
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return preOrderBuild(preorder, inorder);
        }

        private TreeNode preOrderBuild(int[] preorder, int[] inorder) {
            if (preorder.length == 0) return null;

            TreeNode root = new TreeNode(preorder[0]);
            // 这样可以知道，root左边的元素是preorder[1, sep]，root右边的元素是preorder[sep+1:]
            int sep = search(inorder, root.val);

            root.left = preOrderBuild(Arrays.copyOfRange(preorder, 1, sep + 1), Arrays.copyOfRange(inorder, 0, sep));
            root.right = preOrderBuild(Arrays.copyOfRange(preorder, sep + 1, preorder.length), Arrays.copyOfRange(inorder, sep + 1, inorder.length));

            return root;
        }

        private int search(int[] array, int target) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == target) {
                    return i;
                }
            }
            throw new RuntimeException("not possible.");
        }
    }
}
