package dynamic_programming;

import java.util.Arrays;

public class FindMin {
    static int minPath(int[][] grid, int m, int n, int i, int j, int[][] dp){
        if(i == m && j == n){
            return grid[i][j];
        }
        if (i > m || j > n){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int left = minPath(grid, m, n, i+1, j, dp);
        int down = minPath(grid, m, n, i, j+1, dp);
        return dp[i][j] = grid[i][j] + Integer.min(left, down);
    }

    public static void main(String[] args) {
        int[][] grid = {{5, 9, 6},{11, 5, 2}};
        int[][] dp = new int[grid.length][grid[0].length];
        Arrays.stream(dp).forEach(ar -> Arrays.fill(ar, -1));
        System.out.println(minPath(grid, grid.length-1, grid[0].length-1, 0, 0, dp));
        Arrays.stream(dp).forEach(ar -> System.out.println(Arrays.toString(ar)));
    }
}
