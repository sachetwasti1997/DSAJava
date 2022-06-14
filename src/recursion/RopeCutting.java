package recursion;

import java.util.Arrays;

public class RopeCutting {

    static int cutRope(int n, int a, int b, int c, int[] t){
        if(n < 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        return Integer.max(t[n-a], Integer.max(t[n-b], t[n-c]));
    }

    public static void main(String[] args){
        int[]tr = new int[6];
        Arrays.fill(tr, -1);
        int t = cutRope(5, 2, 5, 1, tr);
        System.out.println(Arrays.toString(tr));
        System.out.println(t);
    }

}
