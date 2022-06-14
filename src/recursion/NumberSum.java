package recursion;

import java.io.PrintStream;

public class NumberSum {

    static PrintStream print = System.out;

    public static int sumToN(int n, int sum){
        if(n == 0){
            return sum;
        }
        return sumToN(n-1, sum + n);
    }

    public static void main(String[] args){
        print.println(sumToN(4, 0));
    }

}
