package binary_search;

public class BinarySearch {

    public static int binarySearchIterative(int[] arr, int x){
        int l = 0, r = arr.length-1;
        while (l <= r){
            int mid = (l+r)/2;
            if (arr[mid] == x){
                return mid;
            }else if(arr[mid] < x){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int l, int r, int x){
        if(l > r){
            return -1;
        }
        int mid = (l+r)/2;
        if(arr[mid] == x){
            return mid;
        }
        else if(arr[mid] > x){
            return binarySearch(arr, l, r - 1, x);
        }
        else{
            return binarySearch(arr, l+1, r, x);
        }
    }

    public static int binarySearchRecursive(int[] arr, int x){
        return binarySearch(arr, 0, arr.length-1, x);
    }

    public static void main(String[] args){
        int[] arr = new int[]{10, 20, 30, 40, 50, 60, 70};
        System.out.println(binarySearchRecursive(arr, 10));
    }

}
