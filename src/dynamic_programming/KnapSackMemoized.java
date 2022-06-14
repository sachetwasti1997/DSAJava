package dynamic_programming;

import java.util.Arrays;

public class KnapSackMemoized {

    private static int knapSack(int[] wt, int[] val, int capacity, int n, int[][]t){
        if(n == 0){
            return 0;
        }
        if(t[n][capacity] != -1){
            return t[n][capacity];
        }
        if(wt[n-1] <= capacity){
            return t[n][capacity] = Integer.max(val[n-1]+knapSack(wt, val, capacity - wt[n-1], n-1, t), knapSack(wt, val, capacity, n-1, t));
        }else{
            return t[n][capacity] = knapSack(wt, val, capacity, n-1, t);
        }
    }

    public static void main(String[] args){
        int[][] t = new int[5][8];
        Arrays.stream(t).forEach(arr -> Arrays.fill(arr, -1));
        int profit = knapSack(new int[]{1, 3, 4, 5}, new int[]{1, 4, 5, 7}, 7, 4, t);
        System.out.println(profit);
    }

}
