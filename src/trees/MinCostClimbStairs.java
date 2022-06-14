package trees;

import java.util.*;

public class MinCostClimbStairs {

    public int findMinCost(int[] cost, int[] t, int numberSteps, int n){
        if(numberSteps >= n)return 0;
        if(t[numberSteps] != -1){
            return t[numberSteps];
        }
        return t[numberSteps] = Integer.min(cost[numberSteps] +findMinCost(cost, t, numberSteps+1, n), cost[numberSteps] +findMinCost(cost, t, numberSteps+2, n));
    }
    public int minCostClimbingStairs(int[] cost) {
        int[] t = new int[cost.length+1];
        Arrays.fill(t, -1);
        findMinCost(cost, t, 0, cost.length);
        if(t[0] > t[1]) return t[1];
        else return t[0];
    }

}
