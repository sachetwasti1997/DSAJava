package dynamic_programming;

import java.util.Arrays;

public class UniquePaths {

    public int uniquePathsHelper(int i, int j, int m, int n, int[][] t) {
        if (i == m && j == n){
            return 1;
        }
        if (i >m || j > n){
            return 0;
        }
        if(t[i][j] != -1){
            return t[i][j];
        }
        return t[i][j] = uniquePathsHelper(i+1, j, m, n, t) + uniquePathsHelper(i, j+1, m, n, t);
    }

    public int uniquePaths(int m, int n) {
        int[][] t = new int[m][n];
        Arrays.stream(t).forEach(arr -> Arrays.fill(arr, -1));
        int tr = uniquePathsHelper(0, 0, m-1, n-1, t);
        Arrays.stream(t).forEach(arr -> System.out.println(Arrays.toString(arr)));
        return tr;
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(23, 12));
    }
}
