package trie;

import java.util.*;

public class AlienDictionary {

    static class TrieNode{
        Map<Character, TrieNode> children;
        char nodeVal;
        boolean isEnd = false;
        public TrieNode(char nodeVal) {
            this.nodeVal = nodeVal;
            children = new LinkedHashMap<>();
        }
        @Override
        public String toString() {
            return "TrieNode{" +
                    "children=" + children +
                    ", isEnd=" + isEnd +
                    '}';
        }
    }

    public boolean insert(TrieNode root, String word){
        var temp = root;
        int n = 0;
        while(n < word.length()){
            if(!temp.children.containsKey(word.charAt(n))){
                temp.children.put(word.charAt(n), new TrieNode(word.charAt(n)));
            }
            temp = temp.children.get(word.charAt(n));
            n ++;
        }
        if(temp.isEnd){
            return false;
        }
        temp.isEnd = true;
        return true;
    }

    String traverseLevelOrder(TrieNode root, Set<Character> sett, String res){
        if(root == null){
            return "";
        }
        Queue<TrieNode> queTrie = new LinkedList<>();
        for(Map.Entry<Character, TrieNode> trieMap: root.children.entrySet()){
            queTrie.add(trieMap.getValue());
        }
        while(!queTrie.isEmpty()){
            var temp = queTrie.remove();
            if(!sett.contains(temp.nodeVal)){
                res += temp.nodeVal;
                sett.add(temp.nodeVal);
            }
            for(Map.Entry<Character, TrieNode> trieMap: temp.children.entrySet()){
                queTrie.add(trieMap.getValue());
            }
        }
        return res;
    }

    public String alienOrder(String[] words) {
        TrieNode root = new TrieNode('0');
        Set<String> verifySet = new HashSet<>();
        for(int i=0; i<words.length; i++){
            verifySet.add(words[i]);
        }
        for(int i=0; i<words.length; i++){
            var t = !insert(root, words[i]);
            if(verifySet.size() > 1 && t)return "";
        }
        var setRes = new HashSet<Character>();
        var res = "";
        res = traverseLevelOrder(root, setRes, res);
        return res;
    }

    public static void main(String[] args){
        String[] words = {"aac","aabb","aaba"};
        AlienDictionary al = new AlienDictionary();
        al.alienOrder(words);
    }

}
