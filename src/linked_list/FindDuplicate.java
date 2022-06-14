package linked_list;

import java.util.*;

public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;

        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast){
                break;
            }
            System.out.println(Arrays.toString(nums));
        }

        int slow2 = 0;
        while(slow != slow2){
            slow = nums[slow];
            slow2 = nums[slow2];
        }
        return slow2;
    }

    public static void main(String[] args){
        int[] nums = {1,3,4,2,2};
        FindDuplicate fD = new FindDuplicate();
        fD.findDuplicate(nums);
    }

}
