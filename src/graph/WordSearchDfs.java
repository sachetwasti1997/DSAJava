package graph;

import java.util.*;

public class WordSearchDfs {

    boolean dfs(char[][] board, String word, int i, int j, int count){
        if(count == word.length()){
            return true;
        }

        if(i >= board.length || j >= board[0].length || i < 0 || j < 0){
            return false;
        }
        if( board[i][j] != word.charAt(count)){
            return false;
        }
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean found = dfs(board, word, i+1, j, count + 1)
                || dfs(board, word, i, j+1, count + 1)
                || dfs(board, word, i-1, j, count + 1)
                || dfs(board, word, i, j-1, count + 1);
        board[i][j] = temp;
        return found;
    }

    public List<String> findWord(){
        char[][] board = {
                {'o', 'a', 'b', 'n'},
                {'o', 't', 'a', 'e'},
                {'a', 'h', 'k', 'r'},
                {'a', 'f', 'l', 'v'}
        };
        Boolean[][] positionVisited = new Boolean[board.length+1][board[0].length+1];
        Arrays.stream(positionVisited).forEach(arr -> Arrays.fill(arr, null));
        String[] word = {"oa", "oaa"};
        List<String> strList1 = new ArrayList<>();

            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[0].length; j++){
                    for(int stri=0; stri<word.length; stri++){
                    if(board[i][j] == word[stri].charAt(0) && dfs(board, word[stri], i, j, 0)){
                        strList1.add(word[stri]);
                    }
                }
            }
        }
        return strList1;
    }

    public static void main(String[] args){
        WordSearchDfs w = new WordSearchDfs();
        var wres = w.findWord();
        System.out.println(wres);
    }

}
