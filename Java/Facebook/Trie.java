// Created by Rym on 11/05/2016

// Implement a trie with insert, search, and startsWith method.

class TrieNode {
    public boolean isWord = false;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
}


public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // insert a word into the trie
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isWord = true;
    }

    // returns if the word is in the trie
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) return false;
            curr = curr.children[idx];
        }
        return curr.isWord;
    }
    
    // returns if there is any word in the trie
    // that starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (curr.children[idx] == null) return false;
            curr = curr.children[idx];
        }
        return true;
    }
}
