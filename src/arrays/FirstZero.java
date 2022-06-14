package arrays;

import java.util.Arrays;

public class FirstZero {

    public void moveZeroes(int[] nums) {
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[count];
                nums[count] = temp;
                count ++;
            }
        }
    }

    public static void main(String[] args){
        int[] num = {1, 0, 1};
        FirstZero fz = new FirstZero();
        fz.moveZeroes(num);
        System.out.println(Arrays.toString(num));
    }

}
