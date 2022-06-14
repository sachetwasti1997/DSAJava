package dynamic_programming;

import java.util.Arrays;

public class CoinChangePermutations {

    public int coinChange(int[] coinArr, int sum, int askedSum, int[] t){
        if (sum == askedSum){
            return 1;
        }
        if(sum > askedSum){
            return 0;
        }
        if(t[sum] != -1){
            return t[sum];
        }
        int tempSum = 0;
        for (int i=0; i<coinArr.length; i++){
            tempSum += coinChange(coinArr, sum+coinArr[i], askedSum, t);
        }
        return  t[sum] = tempSum;
    }

    public int combinationSum4(int[] nums, int target) {
        int[] t = new int[target+1];
        Arrays.fill(t, -1);
        int tr = coinChange(nums, 0, target, t);
        System.out.println(Arrays.toString(t));
        return tr;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,5};
        int target = 5;
        CoinChangePermutations coinChangePermutations = new CoinChangePermutations();
        System.out.println(coinChangePermutations.combinationSum4(arr, target));
    }

}
