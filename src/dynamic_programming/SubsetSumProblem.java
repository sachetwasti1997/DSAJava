package dynamic_programming;

import java.util.Arrays;

public class SubsetSumProblem {

    static boolean subsetSum(int[] arr, int sum, int n){
        if(sum == 0){
            return true;
        }
        if(n == 0){
            return false;
        }
        if(arr[n-1] <= sum){
            return subsetSum(arr, sum-arr[n-1], n-1) || subsetSum(arr, sum, n-1);
        }else{
            return subsetSum(arr, sum, n-1);
        }
    }

    static boolean subsetSumMemoized(int[] arr, int sum, int n, Boolean[][]t){
        if(sum == 0){
            return true;
        }
        if(n == 0){
            return t[n][sum] =false;
        }
        if(t[n][sum] != null){
            return t[n][sum];
        }
        if(arr[n-1] <= sum){
            return t[n][sum] = subsetSumMemoized(arr, sum-arr[n-1], n-1, t) || subsetSumMemoized(arr, sum, n-1, t);
        }else{
            return t[n][sum] = subsetSumMemoized(arr, sum, n-1, t);
        }
    }

    static boolean subsetSumTopDown(int[] arr, int sum, int n){
        boolean [][] t = new boolean[n+1][sum+1];
        Arrays.fill(t[0], false);
        for(int j=0; j<n+1; j++){
            t[j][0] = true;
        }
        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        Arrays.stream(t).forEach(ar -> System.out.println(Arrays.toString(ar)));
        return t[n][sum];
    }

    public static void main(String[] args){
        int[] arr = {2, 1, 7, 8, 12};
        int sum = 11;
        System.out.println(subsetSum(arr, sum, arr.length));
        Boolean[][] t = new Boolean[arr.length+1][sum+1];
        Arrays.stream(t).forEach(ar -> Arrays.fill(ar, null));
        System.out.println(subsetSumMemoized(arr, sum, arr.length, t));
        Arrays.stream(t).forEach(ar -> System.out.println(Arrays.toString(ar)));
        System.out.println(subsetSumTopDown(arr, sum, arr.length));
    }
}
