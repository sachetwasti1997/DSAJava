package binary_search;

public class RotatedSortedArray {

    public int search(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while(l <= r){
                int mid = (l+r)/2;
                if(nums[mid] == target){
                    return mid;
                }
                // left sorted portion
                if(nums[l] <= nums[mid]){
                    if(target > nums[mid] || target < nums[l]){
                        l = mid + 1;
                    }else{
                        r = mid - 1;
                    }
                }else{
                    if(target >nums[r] || target < nums[mid]){
                        r= mid-1;
                    }else{
                        l= mid +1;
                    }
                }
            }
            return -1;
    }

}
