package dynamic_programming;

public class KnapSackRecursive {

    public static int knapSackRecursive(int[] val, int[] wt, int n, int capacity){
        if(n == 0){
            return 0;
        }
        if(wt[n-1] <= capacity){
            return Integer.max(val[n-1] + knapSackRecursive(val, wt, n-1, (capacity - wt[n-1])), knapSackRecursive(val, wt, n-1, capacity));
        }else{
            return knapSackRecursive(val, wt, n-1, capacity);
        }
    }

    public static void main(String[] args){
        int profit = knapSackRecursive(new int[]{1, 4, 5, 7}, new int[]{1, 3, 4, 5}, 4, 7);
        System.out.println(profit);
    }

}
