package dynamic_programming;

import java.util.*;

public class LongestPath {
    public int dfsFind(int[][] res, int i, int j, int[][] matrix, int element){
        if(i >= 0 && j >= 0 && j < matrix[0].length && i < matrix.length){
            if(matrix[i][j] <= element){
                return 0;
            }
            if(res[i][j] != -1){
                return res[i][j];
            }
            int max = 1;
            max = Integer.max(1+dfsFind(res, i, j+1, matrix, matrix[i][j]), max);
            max = Integer.max(max, 1+dfsFind(res, i+1, j, matrix, matrix[i][j]));
            max = Integer.max(max, 1+dfsFind(res, i-1, j, matrix, matrix[i][j]));
            max = Integer.max(max, 1+dfsFind(res, i, j-1, matrix, matrix[i][j]));
            return res[i][j] = max;
        }
        return 0;
    }
    public int longestIncreasingPath(int[][] matrix) {
        var res = new int[matrix.length][matrix[0].length];
        Arrays.stream(res).forEach(dp -> Arrays.fill(dp, -1));
        int max = Integer.MIN_VALUE;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(res[i][j] == -1)max = Integer.max(max, dfsFind(res, i, j, matrix, -1));
            }
        }
        Arrays.stream(res).forEach(ar -> System.out.println(Arrays.toString(ar)));
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1}};
        LongestPath l = new LongestPath();
        System.out.println(l.longestIncreasingPath(matrix));
    }
}
