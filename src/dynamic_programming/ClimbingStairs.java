package dynamic_programming;

import java.util.Arrays;

public class ClimbingStairs {

    public static int calculateNumberOfWays(int numberSteps, int n, int[] t){
        if (numberSteps == n){
            return 1;
        }
        if(n == 0){
            return 0;
        }
        if(t[numberSteps] != -1){
            return t[numberSteps];
        }
        if(n > numberSteps){
            return t[numberSteps] = calculateNumberOfWays(numberSteps + 1, n, t) + calculateNumberOfWays(numberSteps + 2, n, t);
        }else{
            return 0;
        }
    }

    public static int climbStairs(int n) {
        int[] t = new int[45];
        Arrays.fill(t, -1);
        int tot = calculateNumberOfWays(0, n, t);
        System.out.println(Arrays.toString(t));
        return tot;
    }

    public static void main(String[] args){
        System.out.println(climbStairs(4));
    }
    /**
     * 2, 2
     * 1, 1, 1, 1
     * 2, 1, 1
     * 1, 2, 1
     * 1, 1, 2
     * 1, 1, 1
     * 1, 2
     * 2, 1
     */

}
