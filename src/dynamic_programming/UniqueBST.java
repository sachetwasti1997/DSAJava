package dynamic_programming;

import java.util.Arrays;

public class UniqueBST {
    public static void main(String[] args) {
        int n = 5;
        var dp = new int[6];
        Arrays.fill(dp, 1);
        dp[0] = 1;
        for(int i=1; i <= 5; i++){
            dp[i] = 0;
            for (int j=0; j<i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        System.out.println(Arrays.toString(dp));
    }
}
