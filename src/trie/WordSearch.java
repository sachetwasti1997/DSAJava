package trie;

import java.util.*;
import java.util.stream.Collectors;

public class WordSearch {

    static class TrieNode{
        Map<Character, TrieNode> children;
        boolean isEnd = false;
        String word;

        public TrieNode() {
            children = new HashMap<>();
        }

        @Override
        public String toString() {
            return "TrieNode{" +
                    "children=" + children +
                    ", isEnd=" + isEnd +
                    ", word='" + word + '\'' +
                    '}';
        }
    }

    public static void insert(TrieNode root, String word){
        var temp = root;
        int n = 0;
        while(n < word.length()){
            if(!temp.children.containsKey(word.charAt(n))){
                temp.children.put(word.charAt(n), new TrieNode());
            }
            temp = temp.children.get(word.charAt(n));
            n++;
        }
        temp.isEnd = true;
        temp.word = word;
    }

    public static boolean findWord(char[][] board, int i, int j, TrieNode root, Set<String> lst){
        if(root == null){
            return false;
        }
        if(root.isEnd){
            lst.add(root.word);
//            return true;
        }
        if(i >= board.length || j >= board[0].length || i < 0 || j < 0){
            return false;
        }
        if(board[i][j] == ' ' || !root.children.containsKey(board[i][j])){
            return false;
        }
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean found = findWord(board, i + 1, j, root.children.get(temp), lst) ||
                findWord(board, i, j+1, root.children.get(temp), lst) ||
                findWord(board, i - 1, j, root.children.get(temp), lst) ||
                findWord(board, i, j-1, root.children.get(temp), lst);
        board[i][j] = temp;
        return found;
    }

    public static List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(int i=0; i<words.length; i++){
            insert(root, words[i]);
        }
        System.out.println(root);
        Set<String> res = new HashSet<>();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                findWord(board, i, j, root, res);
            }
        }
        return res.stream().collect(Collectors.toList());
    }

    public static void main(String[] args){
        char[][] board = {
                {'o','a','b','n'},
                {'o','t','a','e'},
                {'a', 'h', 'k', 'r'},
                {'a', 'f', 'l', 'v'}
        };
        String[] words = {"oa","oaa"};
        var r = findWords(board, words);
        System.out.println(r);
    }
    /**
     * [["o","a","b","n"],["o","t","a","e"],["a","h","k","r"],["a","f","l","v"]]
     * ["oa","oaa"]
     */

}
