package arrays;

public class MaximumDiffWithOrder {

    public int maxProfit(int[] prices) {
        int minValue = prices[0], maxDiff = Integer.MIN_VALUE;
        for(int i=1; i<prices.length; i++){
            maxDiff = Integer.max(maxDiff, prices[i] - minValue);
            minValue = Integer.min(minValue, prices[i]);
        }
        if(maxDiff < 0){
            return 0;
        }
        return maxDiff;
    }


}
