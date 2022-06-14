package Heap;

class Heap {
    private int[] arr;
    private int size;
    private int capacity;
    Heap(int c){
        arr = new int[c];
        size = 0;
        capacity = c;
    }
    void precolateUp(int index){
        if(index == 0){
            return;
        }
        if(arr[(index-1)/2] > arr[index]){
            int temp = arr[index];
            arr[index] = arr[(index-1)/2];
            arr[(index-1)/2] = temp;
            precolateUp((index-1)/2);
        }
    }

    void addItem(int data){
        arr[size] = data;
        size++;
        for(int i = size - 1; i != 0 && arr[(i-1)/2] > arr[i];){
            int temp = arr[i];
            arr[i] = arr[(i-1)/2];
            arr[(i-1)/2] = temp;
            i = (i-1)/2;
        }
    }

    void precolateDown(int index){
        int largest = index;
        if((2*index + 1) <= size && arr[largest] > arr[(2*index)+1]){
            largest = 2*index + 1;
        }
        if((2 * index + 2) <= size && arr[largest] > arr[(2*index)+2]){
            largest = 2 * index + 2;
        }
        if(largest != index){
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            precolateDown(largest);
        }
    }

    int pop(){
        if(size > 0){
            int temp = arr[0];
            arr[0] = arr[size-1];
            size --;
            precolateDown(0);
            return temp;
        }
        return -1;
    }

    void setItemAtIndex(int index, int data){
        arr[index] = data;
    }

    void showArr(){
        for(int i=0; i<size; i++){
            System.out.print(arr[i]+" ");
        }
    }

    boolean isEmpty(){
        return size == 0;
    }
}

public class HeapOperation{

    private final Heap heap;

    public HeapOperation(int c){
        heap = new Heap(c);
    }

    public void addToHeap(int data){
        heap.addItem(data);
    }

    public void showArr(){
        heap.showArr();
    }

    public void decreaseKey(int index, int data){
        heap.setItemAtIndex(index, data);
        heap.precolateUp(index);
    }

    public static void main(String[]args){
        HeapOperation heapOperationMinHeap = new HeapOperation(20);
        heapOperationMinHeap.addToHeap(20);
        heapOperationMinHeap.addToHeap(10);
        heapOperationMinHeap.addToHeap(5);
        heapOperationMinHeap.addToHeap(15);
        heapOperationMinHeap.addToHeap(15);
        heapOperationMinHeap.addToHeap(15);
        heapOperationMinHeap.addToHeap(22);
        heapOperationMinHeap.addToHeap(2);
        heapOperationMinHeap.addToHeap(45);
        heapOperationMinHeap.addToHeap(22);
        heapOperationMinHeap.addToHeap(2);
        heapOperationMinHeap.addToHeap(45);
        heapOperationMinHeap.addToHeap(1);
        heapOperationMinHeap.showArr();
        heapOperationMinHeap.decreaseKey(7, 2);
        System.out.println();
        heapOperationMinHeap.showArr();
        System.out.println();
        while(!heapOperationMinHeap.heap.isEmpty()){
            System.out.println(heapOperationMinHeap.heap.pop());
//            heapOperationMinHeap.heap.showArr();
//            System.out.println();
        }
    }

}


