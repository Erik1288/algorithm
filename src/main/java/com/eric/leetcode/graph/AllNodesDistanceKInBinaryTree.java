package com.eric.leetcode.graph;

import com.eric.model.tree.TreeNode;
import com.eric.util.TreeCodec;

import java.util.*;

/**
 * User: Eric
 * Date: 2020/2/3
 *
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 *
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 *  
 *
 * 示例 1：
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 *
 * 输出：[7,4,1]
 *
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 *
 *
 *
 * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 *  
 *
 * 提示：
 *
 * 给定的树是非空的，且最多有 K 个结点。
 * 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
 * 目标结点 target 是树上的结点。
 * 0 <= K <= 1000.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AllNodesDistanceKInBinaryTree {
    public static void main(String[] args) {
        new Solution().distanceK(TreeCodec.deserialize("[3,5,1,6,2,0,8,null,null,7,4]"), null, 2);
    }

    static class Solution {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();

        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            List<Integer> result = new ArrayList<>();


            treePreOrder(root, graph, null);

            Set<TreeNode> marked = new HashSet<>();
            graphDFS(target, K, marked, result);

            return result;
        }

        private void graphDFS(TreeNode beginNode, int k, Set<TreeNode> marked, List<Integer> result) {
            if (beginNode == null) return ;

            /*###################*/
            if (marked.contains(beginNode)) return ;

            if (k == 0) result.add(beginNode.val);
            marked.add(beginNode);
            /*###################*/

            for (TreeNode graphNode: graph.get(beginNode)) {
                graphDFS(graphNode, k - 1, marked, result);
            }
        }

        /**
         * 树转成图
         */
        private void treePreOrder(TreeNode root, Map<TreeNode, List<TreeNode>> graph, TreeNode parent) {
            if (root == null) return ;

            /*################################*/
            // 初始化图节点的分支列表
            if (!graph.containsKey(root)) {
                List<TreeNode> branches = new ArrayList<>();
                graph.put(root, branches);
            }

            if (parent != null) graph.get(root).add(parent);
            if (root.left != null) graph.get(root).add(root.left);
            if (root.right != null) graph.get(root).add(root.right);
            /*################################*/

            treePreOrder(root.left, graph, root);
            treePreOrder(root.right, graph, root);
        }
    }
}
