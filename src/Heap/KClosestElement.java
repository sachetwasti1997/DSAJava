package Heap;

import java.util.Arrays;

public class KClosestElement {

    static class IndexDifferenceHolder{
        int difference;
        int index;
        public IndexDifferenceHolder(int difference, int index){
            this.difference = difference;
            this.index = index;
        }
    }

    static class MinHeap{
        IndexDifferenceHolder[] heap;
        int size;
        int capacity;
        public MinHeap(int capacity){
            this.capacity = capacity;
            heap = new IndexDifferenceHolder[capacity];
        }
        void insertData(int data, int index){
            heap[size++] = new IndexDifferenceHolder(data, index);
            for (int i=size-1; i != 0 && heap[i].difference < heap[(i-1)/2].difference;){
                var temp = heap[(i-1)/2];
                heap[(i-1)/2] = heap[i];
                heap[i] = temp;
                i = (i-1)/2;
            }
        }
        void maxHeapify(int index){
            int smallest = index;
            int left = (2*index+1);
            int right = (2*index+2);
            if (left < size && heap[smallest].difference > heap[left].difference){
                smallest = left;
            }
            if (left < size && heap[smallest].difference > heap[right].difference){
                smallest = right;
            }
            if(smallest != index){
                var temp = heap[index];
                heap[index] = heap[smallest];
                heap[smallest] = temp;
                maxHeapify(smallest);
            }
        }
        IndexDifferenceHolder pop(){
            var temp = heap[0];
            heap[0] = heap[size-1];
            maxHeapify(0);
            return temp;
        }

        IndexDifferenceHolder peek(){
            return heap[0];
        }
    }

    public static int[] kClosestElement(int[] arr, int k, int x){
        MinHeap minHeap = new MinHeap(arr.length);
        for (int i = 0; i < arr.length; i++){
            minHeap.insertData(Math.abs(x-arr[i]), i);
        }
        int[] closestElements = new int[k];
        for (int i = 0; i < k; i++){
            closestElements[i] = arr[minHeap.pop().index];
        }
        return closestElements;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 15, 7, 3, 4};
        int x = 8;
        int k = 2;
        System.out.println(Arrays.toString(kClosestElement(arr, k, x)));
    }

}
