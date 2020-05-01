package com.eric.leetcode.design;

/**
 * 208. 实现 Trie (前缀树)
 *
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ImplementTriePrefixTree {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        boolean exist = trie.search("apple");   // 返回 true
        exist = trie.search("app");     // 返回 false
        exist = trie.startsWith("app"); // 返回 true
        trie.insert("app");
        exist = trie.search("app");     // 返回 true
    }

    static class Trie {
        private Trie[] children = new Trie[26];
        private boolean isWord = false;

        /** Initialize your data structure here. */
        public Trie() {

        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie cur = this;
            for (int i = 0; i < word.length(); i++) {
                int key = word.charAt(i) - 'a';
                if (cur.children[key] == null) {
                    Trie trie = new Trie();
                    cur.children[key] = trie;

                    cur = trie; // cur下潜到子节点
                } else {
                    cur = cur.children[key]; // cur下潜到子节点
                }
            }
            cur.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie cur = this;
            for (int i = 0; i < word.length(); i++) {
                int key = word.charAt(i) - 'a';
                if (cur.children[key] == null) return false;
                cur = cur.children[key];

            }
            return cur.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie cur = this;
            for (int i = 0; i < prefix.length(); i++) {
                int key = prefix.charAt(i) - 'a';
                if (cur.children[key] == null) return false;
                cur = cur.children[key];

            }
            return true;
        }
    }

}
