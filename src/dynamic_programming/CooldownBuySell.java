package dynamic_programming;

import java.util.*;

public class CooldownBuySell {
    public int dfsMaxProfit(int[] prices, int index, int[][] dp, int buying){
        if(index >= prices.length){
            return 0;
        }
        if(dp[index][buying] != -1){
            return dp[index][buying];
        }
        int cooldown = dfsMaxProfit(prices, index+1, dp, buying);
        if(buying == 0){
            int buy = dfsMaxProfit(prices, index+1, dp, 1) - prices[index];
            dp[index][buying] = Integer.max(buy, cooldown);
        }else{
            int sell = dfsMaxProfit(prices, index+2, dp, 0) + prices[index];
            dp[index][buying] = Integer.max(sell, cooldown);
        }
        return dp[index][buying];
    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        Arrays.stream(dp).forEach(arr-> Arrays.fill(arr, -1));
        int t = dfsMaxProfit(prices, 0, dp, 0);
        return t;
    }
}
