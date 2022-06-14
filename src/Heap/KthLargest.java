package Heap;

import java.util.*;

public class KthLargest {

    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for(int i=0; i<nums.length; i++){
            pq.add(nums[i]);
        }
        while(pq.size() > k){
            pq.remove();
        }
    }

    public int add(int val) {
//        if (pq.peek() > val){
//            return pq.peek();
//        }
        pq.add(val);
        while(pq.size() > k){
            pq.remove();
        }
        System.out.println(pq);
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, arr);
        int t = kthLargest.add(3);
        System.out.println(t);
        t = kthLargest.add(5);
        System.out.println(t);
    }

}
