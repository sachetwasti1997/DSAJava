package dynamic_programming1;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    static int findIncreasingSubsequence(int[] arr, int element, int n, int[] t){
        if(n == 0){
            if(element >= arr[n]){
                return 1;
            }
            return 0;
        }
        if(element > arr[n]){
            return t[n] = Integer.max(1+findIncreasingSubsequence(arr, arr[n], n-1, t), findIncreasingSubsequence(arr, element, n-1, t));
        }else {
            return t[n] = findIncreasingSubsequence(arr, n, n-1, t);
        }
    }

    public static void main(String[]args){
        int[] arr = {10,9,2,5,3,7,101,18};
        int[] t = new int[arr.length];
        Arrays.fill(t, -1);
        t[0] = 1;
        System.out.println(Arrays.toString(t));
        System.out.println((findIncreasingSubsequence(arr, arr[0], arr.length-1, t)));
        System.out.println(Arrays.toString(t));
    }

}
