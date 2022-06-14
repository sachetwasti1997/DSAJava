package arrays;

public class LeftRotateDPlaces {

    public void rotate(int[] nums, int k) {
        if(nums.length == 1 || k == nums.length)return;
        while(k > nums.length){
            k = k - nums.length;
        }
        int[] temp = new int[k];
        for(int i=nums.length-k; i<nums.length; i++){
            temp[i-nums.length+k] = nums[i];
        }
        for(int i=nums.length-1; i>=k; i--){
            nums[i] = nums[i-k];
        }
        for(int i = 0; i<k; i++){
            nums[i] = temp[i];
        }
    }

}
