package trie;
import java.util.*;

public class CountDistinctRowsBinaryMatrix {

    static class TrieNode{
        Map<Integer, TrieNode> charSet = new HashMap<>(2);
    }

    public static boolean insert(TrieNode root, int row, int[][] matrix){
        var temp = root;
        boolean flag = false;
        for(int i=0; i<matrix[0].length; i++){
            if(!temp.charSet.containsKey(matrix[row][i])){
                temp.charSet.put(matrix[row][i], new TrieNode());
                flag = true;
            }
            temp = temp.charSet.get(matrix[row][i]);
        }
        return flag;
    }

    public static void main(String[] args){
        int[][] matrix = {
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0}
        };
        TrieNode root = new TrieNode();
        int res = 0;
        for(int i=0; i<matrix.length; i++){
            if(insert(root, i, matrix)){
                res ++;
            }
        }
        System.out.println(res);
    }

}
