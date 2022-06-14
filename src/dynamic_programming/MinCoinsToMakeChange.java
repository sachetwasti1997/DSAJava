package dynamic_programming;

import java.util.Arrays;

public class MinCoinsToMakeChange {

    static int minCoinsToMakeChange(int[] changes, int amount, int n, int[][] t){
        if(n <= 0){
            return Integer.MAX_VALUE - 1;
        }
        if(amount <= 0){
            return 0;
        }
        if(t[n][amount] != -1){
            return t[n][amount];
        }
        if(changes[n-1] <= amount && changes[n-1] != 0){
            return t[n][amount] = Integer.min(1+minCoinsToMakeChange(changes, amount-changes[n-1], n, t),
                    minCoinsToMakeChange(changes, amount, n-1, t));
        }else{
            return t[n][amount] = minCoinsToMakeChange(changes, amount, n-1, t);
        }
    }

    public static void main(String[]args){
        int[] changeArr = {0};
        int sum = 3;
        int[][] t = new int[changeArr.length+1][sum+1];
        Arrays.stream(t).forEach(ar -> Arrays.fill(ar, -1));
        System.out.println(minCoinsToMakeChange(changeArr, sum, 1, t));
        Arrays.stream(t).forEach(a -> System.out.println(Arrays.toString(a)));
    }

}
