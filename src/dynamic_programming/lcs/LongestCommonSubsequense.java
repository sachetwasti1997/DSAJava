package dynamic_programming.lcs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestCommonSubsequense {

    static int findLengthLCS(String a, String b, int n, int m, Set<Character> lcsSet){
        if(n == 0 || m == 0){
            return 0;
        }
        if(a.charAt(n-1) == b.charAt(m-1)){
            lcsSet.add(a.charAt(n-1));
            return 1+findLengthLCS(a, b, n-1, m-1, lcsSet);
        }
        return Integer.max(findLengthLCS(a, b, n, m-1, lcsSet) , findLengthLCS(a, b, n-1, m, lcsSet));
    }

    static int findLengthLCSMemoised(String a, String b, int n, int m, Set<Character> lcsSet, int[][]t){
        if(n == 0 || m == 0){
            return 0;
        }
        if(t[n][m] != -1){
            return t[n][m];
        }
        if(a.charAt(n-1) == b.charAt(m-1)){
            lcsSet.add(a.charAt(n-1));
            System.out.println(a.charAt(n-1));
            return t[n][m] = 1+findLengthLCSMemoised(a, b, n-1, m-1, lcsSet, t);
        }
        return t[n][m] = Integer.max(findLengthLCSMemoised(a, b, n, m-1, lcsSet, t) , findLengthLCSMemoised(a, b, n-1, m, lcsSet, t));
    }

    static int findLengthLCSBottomUp(String a, String b, int n, int m, Set<Character> lcsSet){
        int[][]t = new int[a.length()+1][b.length()+1];
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    lcsSet.add(a.charAt(i-1));
                    t[i][j] = t[i-1][j-1] + 1;
                }else{
                    t[i][j] = Integer.max(t[i-1][j] , t[i][j-1]);
                }
            }
        }
        return t[n][m];
    }

    public static void main(String[]args){
        String a = "abcdgh";
        String b = "abedfhr";
        Set<Character> lcsSet = new HashSet<>();
//        System.out.println(findLengthLCS(a, b, a.length(), b.length(), lcsSet));

        int[][] t = new int[a.length()+1][b.length()+1];
        Arrays.stream(t).forEach(ar -> Arrays.fill(ar, -1));
//        System.out.println(findLengthLCSMemoised(a, b, a.length(), b.length(), lcsSet, t));
        System.out.println(findLengthLCSBottomUp(a, b, a.length(), b.length(), lcsSet));
        System.out.println(lcsSet);
    }

}
