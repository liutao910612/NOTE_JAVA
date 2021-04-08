package com.kevin.note.java.data.structure.string.search;

/**
 * Trie树
 * 构建Trie树的时间复杂度为O(n),其中n表示所有字符长度的总和。
 * 但是只要我们一旦构建好了Trie树，后续的查询操作将会非常高效，如果查询字符串的长度为k，那么只需要访问k个节点就能够
 * 完成查询操作。
 *
 * @Author:Kevin
 * @Date:Created in 14:44 2021/4/8
 */
public class Trie {

    private TrieNode root = new TrieNode('/');  //存储无意义字符

    /**
     * 往Trie树中插入一个字符
     *
     * @param text
     */
    public void insert(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; i++) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                TrieNode newNode = new TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }

        p.isEndingChar = true;
    }

    /**
     * 在Trie树中查找一个字符串
     *
     * @param pattern
     */
    public boolean find(char[] pattern) {
        TrieNode p = root;
        for (int i = 0; i < pattern.length; i++) {
            int index = pattern[i] - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }

        if (p.isEndingChar == false) {// 不能完全匹配，只是前缀
            return false;
        } else {
            return true;
        }
    }

    static class TrieNode {
        char data;
        TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;

        public TrieNode(char data) {
            this.data = data;
        }
    }
}
