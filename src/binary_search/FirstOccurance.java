package binary_search;

public class FirstOccurance {

    static int firstOccurance(int[] arr, int low, int high, int x){
        if(low > high){
            return -1;
        }
        int mid = (low+high)/2;
        if(arr[mid] == x){
            if(mid-1 > 0 && arr[mid-1] == x){
                return firstOccurance(arr, low, mid - 1, x);
            }
            return mid;
        }
        else if(arr[mid] > x){
            return firstOccurance(arr, low, mid-1, x);
        }
        else{
            return firstOccurance(arr, mid+1, high, x);
        }
    }

//    public static int lastOccuranceRecursive(int[] arr, int x){
//        int low = 0, high = arr.length - 1;
//
//    }

    public static void main(String[]args){
        int[] x = new int[]{10, 10, 10};
        System.out.println(firstOccurance(x, 0, x.length-1, 10));
    }

}
