package com.eric.leetcode.graph;

import java.util.*;

/**
 * User: Eric
 * Date: 2020/2/8
 * <p>
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出: 5
 * <p>
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: 0
 * <p>
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordLadder {
    public static void main(String[] args) {
        int i = new Solution().ladderLength("hit", "cog", new ArrayList(Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"})));
        System.out.println(i);
    }

    static class Solution {
        private class Tuple {
            String node;
            int level;

            public Tuple(String node, int level) {
                this.node = node;
                this.level = level;
            }
        }

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            int wordLength = beginWord.length();

            Map<String, List<String>> graph = generateGraph(wordList, wordLength);
            // BFS
            Queue<Tuple> queue = new ArrayDeque<>();
            Set<String> visit = new HashSet<>();

            queue.add(new Tuple(beginWord, 1));
            if (beginWord.equals(endWord)) return 0;
            visit.add(beginWord);

            while (!queue.isEmpty()) {
                Tuple visitedNode = queue.poll();
                // 查看这个visitedNode的branches
                for (int i = 0; i < wordLength; i++) {
                    String starWord = visitedNode.node.substring(0, i) + "*" + visitedNode.node.substring(i + 1, wordLength);
                    List<String> branches = graph.get(starWord);
                    if (branches == null) continue;
                    for (String branch : branches) {
                        if (visit.contains(branch)) continue;
                        if (branch.equals(endWord)) return visitedNode.level + 1;

                        queue.add(new Tuple(branch, visitedNode.level + 1));
                        visit.add(branch);
                    }
                }
            }

            return 0;
        }

        private Map<String, List<String>> generateGraph(List<String> wordList, int wordLength) {
            Map<String, List<String>> graph = new HashMap<>();
            for (String word : wordList) {
                for (int i = 0; i < wordLength; i++) {
                    String starWord = word.substring(0, i) + "*" + word.substring(i + 1, wordLength);
                    List<String> branches = graph.get(starWord);
                    if (branches == null) {
                        branches = new ArrayList<>();
                        graph.put(starWord, branches);
                    }
                    branches.add(word);
                }
            }

            return graph;
        }
    }
}
