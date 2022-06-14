package dynamic_programming;

import java.util.Arrays;

public class CountSubsetsWithSum {

    static int countSubsets(int[] arr, int sum, int n){
        if(sum == 0){
            return 1;
        }
        if(n == 0){
            return 0;
        }
        if(arr[n-1] <= sum){
            return countSubsets(arr, sum-arr[n-1], n-1) + countSubsets(arr, sum, n-1);
        }else{
            return countSubsets(arr, sum, n-1);
        }
    }

    static int countSubsetsMemoised(int[] arr, int sum, int n, int[][]t){
        if(sum == 0){
            return 1;
        }
        if(n == 0){
            return 0;
        }
        if(t[n][sum] != -1){
            return t[n][sum];
        }
        if(arr[n-1] <= sum){
            return t[n][sum] = countSubsetsMemoised(arr, sum-arr[n-1], n-1, t) + countSubsetsMemoised(arr, sum, n-1, t);
        }else{
            return t[n][sum] = countSubsetsMemoised(arr, sum, n-1, t);
        }
    }

    public static int countSubsetsBottomUp(int[] arr, int sum, int n){
        int[][]t = new int[n+1][sum+1];
        for(int i=0; i<n+1; i++){
            t[i][0] = 1;
        }
        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        Arrays.stream(t).forEach(ar -> System.out.println(Arrays.toString(ar)));
        return t[n][sum];
    }

    public static void main(String[] args){
        int [] arr = {2, 5, 2, 1, 2};
        System.out.println(countSubsets(arr, 5, arr.length));
        int [][] t = new int[arr.length+1][9];
        Arrays.stream(t).forEach(ar -> Arrays.fill(ar, -1));
        System.out.println(countSubsetsMemoised(arr, 8, arr.length, t));
//        System.out.println(countSubsetsBottomUp(arr, 10, arr.length));
    }

}
