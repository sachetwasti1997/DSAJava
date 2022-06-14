package dynamic_programming;

public class MaximumProductArr {

    public int maxProduct(int[] nums) {
        int currentMin = 1, currentMax = 1;
        int res = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) res = Integer.max(res, nums[i]);
        for(int i=0; i<nums.length; i++){
            currentMax = Integer.max(nums[i], Integer.max(nums[i] * currentMax, currentMin * nums[i]));
            currentMin = Integer.min(nums[i], Integer.min(nums[i] * currentMin, currentMax * nums[i]));
            res = Integer.max(res, currentMax);
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
