package dynamic_programming;

import java.util.*;

public class LongestIncreasingSubsequense {

    int findIncreasingSubsequence(int[] arr, int element, int n, int[] t){
        if(n == arr.length){
            return 0;
        }

        int exclude = findIncreasingSubsequence(arr, element, n+1, t);

        int include = 0;
        if(arr[n] > element){
            include = 1+findIncreasingSubsequence(arr, arr[n], n+1, t);
        }
        return Integer.max(exclude, include);
    }
//    public int lengthOfLIS(int[] nums) {
//        int[] t = new int[nums.length + 1];
//        Arrays.fill(t, -1);
//        int tr = findIncreasingSubsequence(nums, Integer.MIN_VALUE, 0, t);
//        return tr;
//    }

    public int lengthOfLIS(int[] nums) {
       int[] lis = new int[nums.length];
       Arrays.fill(lis, 1);
       for(int i=nums.length-1; i >= 0; i++){
           for(int j = i+1; j<nums.length; j++){
               if(nums[i] < nums[j]){
                   lis[i] = Integer.max(lis[i], 1+lis[j]);
               }
           }
       }
       int min = Integer.MIN_VALUE;
       for (int i=0; i<lis.length; i++){
           min = Integer.max(min, lis[i]);
       }
       return min;
    }

    public static void main(String[] args) {
        int [] arr = {10,9,2,5,3,7,101,18};
        LongestIncreasingSubsequense lis = new LongestIncreasingSubsequense();
//        System.out.println(lis.lengthOfLIS(arr));
    }

}
