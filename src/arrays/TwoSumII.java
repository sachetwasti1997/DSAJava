package arrays;

import java.util.*;

public class TwoSumII {

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length == 1 || nums.length == 2 || nums.length == 0){
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(nums);
        var threeSumList = new ArrayList<List<Integer>>(nums.length);
        int index = 0;
        int first = nums[0];
        for(int i = 0; i < nums.length; i++){
            if( i > 0 && nums[i-1] == nums[i])continue;
            int start = i + 1, end = nums.length - 1;
            while(start < end){
                if(nums[i] + nums[start] + nums[end] > 0){
                    end --;
                }else if(nums[i] + nums[start] + nums[end] < 0){
                    start ++;
                }else{
                    threeSumList.add(index, new ArrayList<>(3));
                    threeSumList.get(index).add(nums[i]);
                    threeSumList.get(index).add(nums[start]);
                    threeSumList.get(index).add(nums[end]);
                    start++;
                    while (nums[start-1] == nums[start] && start < end){
                        start ++;
                    }
                }
            }
        }
        return threeSumList;
    }

    public static void main(String[] args){
        int[] nums = {-1,0,1,2,-1,-4};
        TwoSumII tes = new TwoSumII();
        tes.threeSum(nums);
    }

}
