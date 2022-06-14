package dynamic_programming;

import java.util.Arrays;

public class UnboundedKnapSack {

    public static int unboundedKnapSack(int[] arr, int n, int[]val, int wt){
        if(n == 0){
            return 0;
        }
        if(arr[n-1] <= wt){
            return Integer.max(val[n-1] + unboundedKnapSack(arr, n, val, wt - arr[n-1]), unboundedKnapSack(arr, n - 1, val, wt));
        }else{
            return unboundedKnapSack(arr, n-1, val, wt);
        }
    }

    public static int unboundedKnapSackMemoised(int[] arr, int n, int[]val, int wt, int[][]t){
        if(n == 0){
            return 0;
        }
        if(t[n][n] != -1){
            return t[n][wt];
        }
        if(arr[n-1] <= wt){
            return t[n][wt] = Integer.max(val[n-1] + unboundedKnapSackMemoised(arr, n, val, wt - arr[n-1], t), unboundedKnapSackMemoised(arr, n - 1, val, wt, t));
        }else{
            return t[n][wt] = unboundedKnapSackMemoised(arr, n-1, val, wt, t);
        }
    }

    public static void main(String[] args){
        int[] lengthList = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(unboundedKnapSack(lengthList, 8, price, 8));
        int[][] t = new int[lengthList.length+1][9];
        Arrays.stream(t).forEach(ar -> Arrays.fill(ar, -1));
        System.out.println(unboundedKnapSackMemoised(lengthList, 8, price, 8, t));
    }

}
