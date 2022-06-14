package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortK {

    static void sortK(int[]arr, int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(arr.length);
        for(int i=0; i<=k; i++){
            priorityQueue.add(arr[i]);
        }
        int index = 0;
        System.out.println(priorityQueue);
        for(int i= k+1; i<arr.length; i++){
            arr[index++] = priorityQueue.remove();
            priorityQueue.add(arr[i]);
        }
        while (!priorityQueue.isEmpty()){
            arr[index++] = priorityQueue.poll();
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 7, 19, 18};
        sortK(arr, 2);
        System.out.println(Arrays.toString(arr));
    }

}
