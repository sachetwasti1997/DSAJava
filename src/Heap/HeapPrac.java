package Heap;

class MaxHeap{
    private int[] heap;
    private int size;
    private int capacity;
    public MaxHeap(int capacity){
        this.capacity = capacity;
        heap = new int[capacity];
    }
    public void addElement(int element){
        heap[size] = element;
        size++;
        for(int i = size-1; i != 0 && heap[(i-1)/2] < heap[i];){
            int temp = heap[(i-1)/2];
            heap[(i-1)/2] = heap[i];
            heap[i] = temp;
            i = (i-1)/2;
        }
    }
    public void precolateDown(int index){
        int largest = index;
        if((2*index+1) < size && heap[largest] < heap[(2*index+1)]){
            largest = (2*index+1);
        }
        if((2*index+2) < size && heap[largest] < heap[(2*index+2)]){
            largest = (2*index+2);
        }
        if(largest != index){
            int temp = heap[largest];
            heap[largest] = heap[index];
            heap[index] = temp;
            precolateDown(largest);
        }
    }
    public int pop(){
        int temp = heap[0];
        heap[0] = heap[size-1];
        size --;
        precolateDown(0);
        return temp;
    }
    public int peek(){
        return heap[0];
    }
}
class Solution1 {
    public static int findKthLargest(int[] nums, int k) {
        MaxHeap heap = new MaxHeap(nums.length);
        for(int i=0; i < nums.length; i++){
            heap.addElement(nums[i]);
        }
        for(int i=0; i<k; i++){
            int it = heap.pop();
            System.out.println(it);
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,5,6,4};
        findKthLargest(arr, 2);
    }
}

public class HeapPrac {
}
