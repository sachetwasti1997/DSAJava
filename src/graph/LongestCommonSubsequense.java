package graph;
import java.util.*;

public class LongestCommonSubsequense {

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for(Integer i: nums){
            numSet.add(i);
        }
        int maxLength = 0;
        for(Integer i: nums){
            if(!numSet.contains(i - 1)){
                int length = 1;
                while(numSet.contains(i + length)){
                    length ++;
                }
                if(maxLength < length){
                    maxLength = length;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args){
        LongestCommonSubsequense sequence = new LongestCommonSubsequense();
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int t = sequence.longestConsecutive(nums);
        System.out.println(t);
    }

}
