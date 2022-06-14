package dynamic_programming;

import java.util.Arrays;

public class KnapSackTopDown {

    static int knapSackTopDown(int[] wt, int[] val, int capacity, int n){
        int[][] t = new int[n+1][capacity+1];
        for(int i=1; i<n+1; i++){
            for(int j=1; j<capacity+1; j++){
                if(wt[i-1] <= j){
                    t[i][j] = Integer.max(val[i-1]+t[i-1][j-wt[i-1]], t[i-1][j]);
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        for(int i=0; i<n+1; i++){
            System.out.println(Arrays.toString(t[i]));
        }
        return t[n][capacity];
    }

    public static void main(String[] args){
        int profit = knapSackTopDown(new int[]{1, 3, 4, 5}, new int[]{1, 4, 5, 7}, 7, 4);
        System.out.println(profit);
    }

}
