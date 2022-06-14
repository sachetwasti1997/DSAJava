package trie;

import java.io.PrintStream;

public class TrieOperations {

    static PrintStream p = System.out;

    static void insert(TrieNode root, String word){
        var temp = root;
        for(int i=0; i<word.length(); i++){
            if(temp.charSet.containsKey(word.charAt(i))){
                temp = temp.charSet.get(word.charAt(i));
            }else{
                temp.charSet.put(word.charAt(i), new TrieNode());
                temp = temp.charSet.get(word.charAt(i));
            }
        }
        temp.isEnd = true;
        p.println(root);
    }

    static boolean search(TrieNode root, String word){
        int n = 0;
        while(root != null && n < word.length()){
            if(root.charSet.containsKey(word.charAt(n))){
                root = root.charSet.get(word.charAt(n));
            }else{
                return false;
            }
            n ++;
        }
        if(root.isEnd == true){
            return true;
        }else{
            return false;
        }
    }

    static TrieNode delete(TrieNode root, String word, int index){
        if(index == word.length()){
            root.isEnd = false;
            if(root.charSet.isEmpty()){
                return null;
            }
            return root;
        }
        if(!root.charSet.containsKey(word.charAt(index))){
            return root;
        }else{
            var res = delete(root.charSet.get(word.charAt(index)), word, index+1);
            if(res == null){
                root.charSet.remove(word.charAt(index));
                if(root.charSet.isEmpty()){
                    return null;
                }else{
                    return root;
                }
            }
            return root;
        }
    }

    public static void main(String[] args){
        TrieNode root = new TrieNode();
        insert(root, "bat");
        insert(root, "bad");

        insert(root, "geek");
        insert(root, "geeks");

        p.println(search(root, "batt"));
        delete(root, "bat", 0);
        p.println(root);
        delete(root, "geek", 0);
        p.println(root);
        delete(root, "bat", 0);
        p.println(root);
    }

}
