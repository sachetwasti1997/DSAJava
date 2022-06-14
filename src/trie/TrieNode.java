package trie;

import java.util.*;
public class TrieNode {

    public Map<Character, TrieNode> charSet = new HashMap<>(26);
    public boolean isEnd = false;

    @Override
    public String toString() {
        return "TrieNode{" +
                "charSet=" + charSet +
                ", isEnd=" + isEnd +
                '}';
    }
}
