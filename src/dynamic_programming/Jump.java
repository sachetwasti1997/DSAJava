package dynamic_programming;

import java.util.Arrays;

public class Jump {

    static boolean jump(int[] nums, int n, Boolean[] dp){
        if(n == nums.length-1){
            return true;
        }
        if(n > nums.length-1){
            return false;
        }
        if(dp[n] != null){
            return dp[n];
        }
        int steps = nums[n];
        boolean t = false;
        while(steps > 0){
            t = t || jump(nums, n + steps, dp);
            steps--;
        }
        return dp[n] = t;
    }

    public boolean canJump(int[] nums) {
        int[] n = new int[]{1, 2, 3};
        Boolean[] tr = new Boolean[n.length+1];
        Arrays.fill(tr, null);
        boolean t = jump(n, 0, tr);
        System.out.println(t);
        System.out.println(Arrays.toString(tr));
        return t;
    }

    public static void main(String[] args){
        Jump jump = new Jump();
        int[] t = {};
        System.out.println(jump.canJump(t));
    }

}
