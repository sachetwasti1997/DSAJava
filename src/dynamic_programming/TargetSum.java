package dynamic_programming;

public class TargetSum {

    public static int subSetSum(int sum, int[] nums, int n){
        if(sum == 0){
            return 1;
        }
        if(n <= 0){
            return 0;
        }
        if(sum >= nums[n-1]){
            return subSetSum(sum - nums[n-1], nums, n-1) + subSetSum(sum, nums, n-1);
        }else{
            return subSetSum(sum, nums, n-1);
        }
    }

    public static int findTargetSumWays(int[] nums, int target) {
        if(nums.length == 1){
            return 0;
        }
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }
        int subSetSum = (target+sum)/2;
        return subSetSum(subSetSum, nums, nums.length);
    }

    public static void main(String[] args){
        int[] nums = {1};
        int target = 2;
        System.out.println(findTargetSumWays(nums, target));

    }

}
