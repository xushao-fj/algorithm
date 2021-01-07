package com.xsm.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xsm
 * @date 2021/1/7
 * @Description  前缀树
 *
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
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
public class TrieDemo {

    public static void main(String[] args) {
        JavaTrie trie = new JavaTrie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));;
        System.out.println(trie.startsWith("app"));;
        trie.insert("app");
        System.out.println(trie.search("app"));;
    }

}

/** 使用Java api 简单实现*/
class JavaTrie {

    /** 用于存放单词*/
    private Set<String> dictionary = new HashSet<>();

    /** Initialize your data structure here. */
    public JavaTrie() {
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        dictionary.add(word);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return dictionary.contains(word);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        for (String s : dictionary) {
            if (s.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }
}

/** 前缀树版本*/
class Trie {


}









