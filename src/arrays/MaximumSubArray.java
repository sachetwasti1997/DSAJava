package arrays;

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int firstPositive = 0, lastIndex = 1;
        int sum = nums[0];
        int maxSum = sum;
        int minValue = nums[firstPositive];
        while(lastIndex<nums.length){
            if(nums[lastIndex] > 0 && sum < 0){
                firstPositive = lastIndex;
                sum = nums[lastIndex];
                maxSum = Integer.max(maxSum, sum);
            }else{
                sum += nums[lastIndex];
            }
            maxSum = Integer.max(maxSum, sum);
            minValue = Integer.max(nums[lastIndex], minValue);
            lastIndex++;
        }
        if(minValue <= 0){
            return minValue;
        }
        return maxSum;
    }

    public static void main(String[] args){
        int[] nums = {-1, 0};
        MaximumSubArray arr = new MaximumSubArray();
        int t = arr.maxSubArray(nums);
        System.out.println(t);
    }

}
