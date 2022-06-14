package Heap;

import java.util.*;

public class LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {
        if(stones.length == 1){
            return stones[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<stones.length; i++){
            pq.add(stones[i]);
        }
        while(true){
            int max1 = pq.remove();
            int max2 = pq.remove();
            pq.add(max1 - max2);
            if(pq.size() == 1){
                break;
            }
        }
        return pq.remove();
    }

    public static void main(String[] args) {
        int[] nums = {2,2};
        var t = lastStoneWeight(nums);
        System.out.println(t);
    }

}
