package trie;

import java.util.*;

public class WordDictionary {

    Map<Character, WordDictionary> charSet;
    boolean isEnd = false;

    public WordDictionary() {
        charSet = new HashMap<>();
    }

    public void addWord(String word) {
        var temp = this;
        for(int i=0; i<word.length(); i++){
            if(!temp.charSet.containsKey(word.charAt(i))){
                temp.charSet.put(word.charAt(i), new WordDictionary());
            }
            temp = temp.charSet.get(word.charAt(i));
        }
        temp.isEnd = true;
    }

    public boolean searchWithRecursion(String word, int n, WordDictionary root){
        while(n < word.length()){
            if(word.charAt(n) == '.'){
                boolean isWordFound = false;
                if(n == 0)n = n+1;
                for(Map.Entry<Character, WordDictionary>set: root.charSet.entrySet()){
                    isWordFound = isWordFound || searchWithRecursion(word, n, root.charSet.get(set.getKey()));
                    if(isWordFound)return true;
                }
                return false;
            }else if(root.charSet.containsKey(word.charAt(n))){
                root = root.charSet.get(word.charAt(n));
            }else{
                return false;
            }
            n++;
        }
        return root.isEnd;
    }

    public boolean search(String word) {
        return searchWithRecursion(word, 0, this);
    }

    public static void main(String[]args){
        WordDictionary dict = new WordDictionary();
        dict.addWord("bad");
        dict.addWord("dad");
        dict.addWord("mad");

//        System.out.println(dict.search("pad"));
//        System.out.println(dict.search("dad"));
//        System.out.println(dict.search(".ad"));
        System.out.println(dict.search("b.."));
    }

}
