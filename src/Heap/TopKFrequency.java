package Heap;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class CountStoreObject{
    private int count;
    private final int number;
    public CountStoreObject(int count, int number){
        this.count = count;
        this.number = number;
    }
    int getCount(){
        return count;
    }
    int getNumber(){
        return number;
    }
    void incrementCount(){
        count ++;
    }

    @Override
    public String toString() {
        return "CountStoreObject{" +
                "count=" + count +
                ", number=" + number +
                '}';
    }
}

class CountHeap{
    private CountStoreObject[] countStoreObjects;
    private int size;
    private int capacity;
    public CountHeap(int capacity){
        this.capacity = capacity;
        countStoreObjects = new CountStoreObject[capacity];
    }

    void insert(CountStoreObject obj){
        countStoreObjects[size] = obj;
        size++;
        for(int i=size-1; i != 0 && countStoreObjects[i].getCount() > countStoreObjects[(i-1)/2].getCount();){
            var temp = countStoreObjects[i];
            countStoreObjects[i] = countStoreObjects[(i-1)/2];
            countStoreObjects[(i-1)/2] = temp;
            i = (i-2)/2;
        }
    }

    void precolateDown(int index){
        int largest = index;
        if((2 * index + 1) < size && countStoreObjects[(2 * index + 1)].getCount() > countStoreObjects[index].getCount()){
            largest = (2 * index + 1);
        }
        if((2*index+2) < size && countStoreObjects[(2*index+2)].getCount() > countStoreObjects[largest].getCount()){
            largest = (2*index+2);
        }
        if(largest != index){
            var temp = countStoreObjects[index];
            countStoreObjects[index] = countStoreObjects[largest];
            countStoreObjects[largest] = temp;
            precolateDown(largest);
        }
    }

    CountStoreObject pop(){
        {
            var temp = countStoreObjects[0];
            countStoreObjects[0] = countStoreObjects[size-1];
            size--;
            precolateDown(0);
            return temp;
        }
    }

    @Override
    public String toString() {
        return "CountHeap{" +
                "countStoreObjects=" + Arrays.toString(countStoreObjects) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }
}

class Solution{
    static Map<Integer, CountStoreObject> map = new HashMap<>();
    static CountHeap heap;
    public static int[] topKFrequent(int[] nums, int k) {
        for(int i: nums){
            if(!map.containsKey(i)){
                map.put(i, new CountStoreObject(1, i));
            }else{
                map.get(i).incrementCount();
            }
        }
        System.out.println(map);
        heap = new CountHeap(map.size());
        for(Map.Entry<Integer, CountStoreObject> mapCopy: map.entrySet()){
            System.out.println(mapCopy.getValue());
            heap.insert(mapCopy.getValue());
        }
        int[] topKElements = new int[k];
        System.out.println(heap);
        for(int i=0; i<k; i++){
            topKElements[i] = heap.pop().getNumber();
        }
        return topKElements;
    }

    public static void main(String[] args) {
        var nums = new int[]{5,2,5,3,5,3,1,1,3};
        var k = 2;
        var t = topKFrequent(nums, k);
        for (int i: t){
            System.out.print(i+" ");
        }
    }
}

public class TopKFrequency {



}
