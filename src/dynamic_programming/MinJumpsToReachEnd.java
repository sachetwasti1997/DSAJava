package dynamic_programming;

import java.util.Arrays;

public class MinJumpsToReachEnd {

    static int findMinJumps(int[] jumpArr, int n){
        if(n >= jumpArr.length){
            return Integer.MAX_VALUE - 1;
        }
        if(n == jumpArr.length-1){
            return 0;
        }
        int t = Integer.MAX_VALUE;
        int curr_element = jumpArr[n];
        while(curr_element > 0){
            t = Integer.min(t, 1+findMinJumps(jumpArr, n+curr_element));
            curr_element--;
        }
        return t;
    }

    public static void main(String[] args){
        int[]t = new int[6];
        Arrays.fill(t, -1);
        int[] jumps = {4, 1, 5, 3, 1, 3, 2, 1, 8};
        System.out.println(findMinJumps(jumps, 0));
    }

}
