package dynamic_programming;

import java.util.Arrays;

public class HouseRobber {

    public int calculateMaxAmount(int[] nums, int n, int[] t){
        if(n <= 0){
            return 0;
        }
        if (t[n] != -1){
            return t[n];
        }
        return t[n] = Integer.max(nums[n-1] + calculateMaxAmount(nums, n-2, t), calculateMaxAmount(nums, n-1, t));
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int[] storage = new int[nums.length+2];
        Arrays.fill(storage, -1);
        HouseRobber houseRobber = new HouseRobber();
        System.out.println(houseRobber.calculateMaxAmount(nums, nums.length, storage));
    }

}
