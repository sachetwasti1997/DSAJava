package dynamic_programming;

public class WordSearch {

    public boolean doDfs(char[][] board, String word, int n, int i, int j){
        if(n == word.length()){
            return true;
        }
        if(i >= board.length|| j >= board[0].length || i < 0 || j < 0){
            return false;
        }
        if(board[i][j] != word.charAt(n) || board[i][j] == ' '){
            return false;
        }
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean found = doDfs(board, word, n + 1, i + 1, j)
                || doDfs(board, word, n + 1, i, j + 1)
                || doDfs(board, word, n + 1, i - 1, j)
                || doDfs(board, word, n + 1, i, j - 1);
        board[i][j] = temp;
        return found;
    }

    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0) && doDfs(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        char[][] board = {
                {'a'}
        };
        String word = "a";
        WordSearch search = new WordSearch();
        boolean t = search.exist(board, word);
        System.out.println(t);
    }

}
