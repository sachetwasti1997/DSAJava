package dynamic_programming;

import java.util.*;

public class InterleavingStr {
    public boolean dfsIsInterLeave(String s1, String s2,
                                   String s3, int i1, int i2, Boolean[][] dp){
        if(i1 == s1.length() && i2 == s2.length() && i1+i2 == s3.length()){
            return true;
        }
        if(dp[i1][i2] != null){
            return dp[i1][i2];
        }
        if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i1+i2) &&
                dfsIsInterLeave(s1, s2, s3, i1+1, i2, dp)) return true;
        if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i1+i2) &&
                dfsIsInterLeave(s1, s2, s3, i1, i2+1, dp)) return true;
        dp[i1][i2] = false;
        return false;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() < s1.length() + s2.length())return false;
        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];
        Arrays.stream(dp).forEach(ar -> Arrays.fill(ar, null));
        return dfsIsInterLeave(s1, s2, s3, 0, 0, dp);
    }

    public static void main(String[] args) {
        String s1 = "";
        String s2 = "";
        String s3 = "a";
        InterleavingStr str = new InterleavingStr();
        System.out.println(str.isInterleave(s1, s2, s3));
    }
}
