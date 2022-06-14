package dynamic_programming;

import java.util.Arrays;

public class LeetCodeLCS {

    public int findLCS(String text1, String text2, int n, int m, int[][] t){
        if(n == 0 || m==0){
            return 0;
        }
        if(t[n][m] != -1){
            return t[n][m];
        }
        if(text1.charAt(n-1) == text2.charAt(m-1)){
            return t[n][m] = 1 + findLCS(text1, text2, n-1, m-1, t);
        }else{
            return t[n][m] = Integer.max(findLCS(text1, text2, n-1, m, t), findLCS(text1, text2, n, m-1, t));
        }
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] t = new int[text1.length()+1][text2.length()+1];
        for(int i=1; i<text1.length()+1; i++){
            for (int j=1; j<text2.length()+1; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Integer.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[text1.length()][text2.length()];
    }

    public static void main(String[] args){
        LeetCodeLCS lcs = new LeetCodeLCS();
        System.out.println(lcs.longestCommonSubsequence("abcde", "ace"));
    }

}
